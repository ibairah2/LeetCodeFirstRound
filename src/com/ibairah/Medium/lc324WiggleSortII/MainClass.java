package com.ibairah.Medium.lc324WiggleSortII;

import java.util.Arrays;

/**
 * Created by ibairah on 6/20/20.
 *
 * Given an unsorted array nums, reorder it such that nums[0] <
 * nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 *
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 *
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        System.out.println("length  :"+ nums.length);
        int[] smallSet = new int[nums.length/2];
        int[] bigSet = new int[nums.length/2];
        int[] res =  new int[nums.length];
        for(int i = 0 ; i < nums.length/2; i++){
            smallSet[i] = nums[i];
        }
        int idx = 0;
        for(int i = nums.length/2 ; i < nums.length ; i++){
            bigSet[idx] = nums[i];
            idx++;
        }
        System.out.println(" smallSet :"+ Arrays.toString(smallSet));
        System.out.println(" bigSet :"+ Arrays.toString(bigSet));

        int small_idx = 0;
        for( int i = 0; i < nums.length; i+=2 ){
            res[i] = smallSet[small_idx];
            small_idx++;
        }
        System.out.println(" res :"+ Arrays.toString(res));

        small_idx = 0;
        for( int i = 1; i <= nums.length; i+=2 ) {
            res[i] = bigSet[small_idx];
            small_idx++;
        }

        nums = res.clone();
        System.out.println("nums :"+ Arrays.toString(nums));
    }
}

public class MainClass {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        solution.wiggleSort(nums2);
    }
}
