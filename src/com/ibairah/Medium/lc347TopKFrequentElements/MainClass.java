package com.ibairah.Medium.lc347TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ibairah on 6/21/20.
 *
 * Given a non-empty array of integers, return the k most frequent
 * elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique
 * elements.
 * Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the
 * set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        for(int i=0; i<nums.length; i++){
            // 找到当前出现的数字，并且+1
            int freq = map.getOrDefault(nums[i],0) + 1;
            // 把当前数字和出现频率加入map
            map.put(nums[i],freq);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            //根据出现频率创建bucket，如果没有，则创建新的一个列
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();

            // this is why we start i = bucket.length - 1;
            //因为为了找最大的频率，所以从后往前找
            bucket[freq].add(key);
        }

        int[] res = new int[k];

        // k出现最多的前k个数字；
        for(int pos = bucket.length - 1; pos >= 0; pos--){
            if(bucket[pos] != null){
                if( k > 0){
                    for(int n : bucket[pos]){   //n是bucket最后一位数字
                        k--; // for indices problems
                        res[k] = n;            //res的最后一位 = bucket最后一位数字
                    }
                }
            }
        }
        return res;
    }
}
public class MainClass {
}
