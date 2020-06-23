package com.ibairah.Medium.lc137SingleNumberII;

import java.util.HashMap;

/**
 * Created by ibairah on 6/22/20.
 *
 * Given a non-empty array of integers, every element appears three
 * times except for one, which appears exactly once. Find that
 * single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could
 * you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
//
class Solution2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < 32; i++){
            int sum = 0;
            for(int j = 0; i < nums.length; j++){
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}

//O(n), O(n)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(" map :"+ map);
        for(int num : nums){
            if(map.get(num) == 1){
                System.out.println(" num :"+ num);
                return num;
            }
        }
        System.out.println(" -1 ");

        return -1;
    }
}
public class MainClass {
    public static void main(String[] args) {
        int[] test = {2,3,2,2};
        Solution solution = new Solution();
        solution.singleNumber(test);
    }
}
