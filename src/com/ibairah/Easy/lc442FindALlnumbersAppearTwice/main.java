package com.ibairah.Easy.lc442FindALlnumbersAppearTwice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 5/18/20.
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution sl = new Solution();
        sl.findDuplicates(nums);

    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            int index = Math.abs(nums[i]) - 1;         // nums[0] = 3; -> index = 3
            System.out.println(" innums[index] :"+ nums[index]);
            if(nums[index] < 0){        // 小于0说明已经出现过一次
                ls.add(Math.abs(index+1)); // !!!!!
            }
            nums[index] = -nums[index];     // nums[0] = -4;
            System.out.println(" nums[index] after: "+ nums[index]);
        }
        return ls;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            //System.out.println(" innums[index] :"+ nums[index]);
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
            //System.out.println(" nums[index] after: "+ nums[index]);
        }
        return res;
    }
}