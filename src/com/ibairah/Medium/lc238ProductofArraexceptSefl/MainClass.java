package com.ibairah.Medium.lc238ProductofArraexceptSefl;

/**
 * Created by ibairah on 6/18/20.
 *
 * Given an array nums of n integers where n > 1,  return an array
 * output such that output[i] is equal to the product of all the
 * elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of
 * any prefix or suffix of the array (including the whole array)
 * fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space
 * complexity analysis.)
 */


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;

        for(int j = 0; j<nums.length; j++){
            for(int i = 0 ; i < nums.length; i++){
                System.out.println("temp  :"+temp );

                temp *= nums[i] ;
                // System.out.println("  nums[j]:"+ nums[j]);
                temp = temp /nums[j];
            }
            res[j] = temp;
            temp = 1;
        }

        return res;
    }
}


public class MainClass {
}
