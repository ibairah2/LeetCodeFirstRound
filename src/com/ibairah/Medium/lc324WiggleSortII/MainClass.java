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

//解法：思路：
//排序，找中位数
//大于中位数： 从左往右放入，放在奇数位indices
//小于中位数： 从右往左放入，放在偶数位indices
//中位数最后放入

// 1，2，3，4，5，6 median = 3
// 3，6，2，6，1，4
// 0，1，2，3，4，5 =》 indices
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;          //ex:6
        int mid = (n-1) / 2;         //ex: (6-1)/2  = 5/2 => mid = 2
        int idx = 0;
        int[] temp = new int[n];
        for(int i = 0; i<= mid; i++){
            temp[idx] = nums[mid-i];         //temp[0] = nums[2-0]; => temp[0] = 3
            if(idx + 1 < n){                // 0 + 1 < 6
                temp[idx + 1] = nums[n - 1 - i]; // temp[1] = nums[6-1-0] =>temp[1] = 6; //[n - 1 - i]不断往前遍历
            }
            idx += 2;     //+2是因为每次都更新了两个位置
        }
        System.arraycopy(temp,0,nums,0,n);
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
