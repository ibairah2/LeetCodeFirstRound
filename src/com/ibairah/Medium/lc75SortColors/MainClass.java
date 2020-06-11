package com.ibairah.Medium.lc75SortColors;

import java.util.Arrays;

/**
 * Created by ibairah on 6/8/20.
 * Given an array with n objects colored red, white or blue, sort
 * them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for
 * this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using
 * counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and
 * followed by 2's.
 * Could you come up with a one-pass algorithm using only constant
 * space?
 */

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1; // !
        int cur_index = 0;
        int temp = 0;

        while( start < end && cur_index <= end){
            if(nums[cur_index] == 0){
                // swap cur_index with start;
                temp = nums[start];
                nums[start] = nums[cur_index];
                nums[cur_index] = temp;
                cur_index++;
                start++;
            }else if( nums[cur_index] == 2){
                temp = nums[end];
                nums[end] = nums[cur_index];
                nums[cur_index] = temp;

                // !!!!!!!!!!
                // 为什么cur_index不++，因为cur_index之后的数对我们来
                // 说是未知的，所以end的那一位可能是0，1，2任何一位
                // [1,0,0,1,2,1,1,2] -> 最后一位是2，如果2和2交换，
                // 并且index++，则跳过了一个2
                end--;
            }else{ // occur 1
                cur_index++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int[] arr = new int[3];
        for(int i=0; i<nums.length; i++) {
            arr[nums[i]]++;
            System.out.println(" nums[i] :"+ nums[i]);
            System.out.println(" arr[nums[i]] :"+ arr[nums[i]]);
            System.out.println(" arr :"+ Arrays.toString(arr));
            System.out.println("---------Divided Line-----------" );
        }
        int k = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}


public class MainClass {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors2(nums);
    }

}