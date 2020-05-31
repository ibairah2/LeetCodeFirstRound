package com.ibairah.Medium.lc15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 5/28/20.
 * Given an array nums of n integers, are there elements a, b, c in
 * nums such that a + b + c = 0? Find all unique triplets in the
 * array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class MainClass {
    public static void main(String[] args) {
        int[] test ={-1, 0, 1, 2, -1, -4};
        int[] test2 ={0,0,0};
        Solution sl = new Solution();
        sl.threeSum(test);
        sl.threeSum(test2);
    }
}class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //此题必须sort才能做 【-4，-1，-1，0，1，2】
        Arrays.sort(nums);

        // 思路遍历第一位，用Two Sum思想做后面情况
        for( int i = 0 ; i < nums.length -2; i++ ){
            // 处理i(第一位)出现重复情况，如果下一个遇上一位重复，则跳过
            if(i ==0 || nums[i] != nums[i - 1]){
                //处理后两位的情况, 设置boundary
                int low_bound = i + 1 ; // 从第二位开始
                int high_bound = nums.length-1; // 从最后一位开始
                int target = -nums[i];// 类似two sum 设置target
                while(low_bound < high_bound){
                    // 如果有meet the target
                    if(nums[low_bound] + nums[high_bound] == target ){
                        res.add(Arrays.asList(nums[i],nums[low_bound], nums[high_bound]));
                        //!!!! 处理low_bound(第二位)出现重复情况
                        while(low_bound<high_bound && nums[low_bound] == nums[low_bound+1]){
                            low_bound++;
                        }
                        //!!!! 处理high_bound(第三位)出现重复情况
                        while(low_bound<high_bound && nums[high_bound] == nums[high_bound-1]){
                            high_bound--;
                        }
                        // 添加进入结果后，需要更新两边界限
                        // 因为为了不要重复，所以两天同时加减
                        low_bound++;
                        high_bound--;
                    }
                    //处理没有meet target情况，如果结果与target相比偏大就减少右边
                    //如果结果与target相比偏小，就增加左边
                    else if(nums[low_bound] + nums[high_bound] < target  ){
                        low_bound++;
                    }
                    else {
                        high_bound--;
                    }
                }
            }
        }
        return res;
    }
}