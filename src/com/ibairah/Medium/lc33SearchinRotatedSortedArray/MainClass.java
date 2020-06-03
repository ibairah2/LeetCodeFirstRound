package com.ibairah.Medium.lc33SearchinRotatedSortedArray;

import java.awt.font.NumericShaper;

/**
 * Created by ibairah on 6/2/20.
 * Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array
 * return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O
 * (log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */


//https://www.youtube.com/watch?v=lWEIIFFflQY
//二分法 binary search

//  为什么(start + end)/2会出现overflow?
//  int start = 0x7ffffffe, end = 0x7fffffff;
//  int mid = start + (end - start) / 2;
//  int mid = (start + end) / 2;


class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 ) return -1;

        int left = 0;
        int right = nums.length-1;

        //类似bound
        while(left + 1  < right){ // 为了防止重叠,然后跳出进行两个判断
            int mid = left + (right-left)/2; //!!!!!处理overflow！！！
            // 因为是一个rotated的数组，不知到中间的那位数的大小
            //[4,5,6,7,0,1,2] --> mid = 7 > left
            if(nums[mid] > nums[left]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid;
                }else left = mid;
            }else if (nums[mid] < nums[right]){
                if(target <= nums[right] && target >= nums[mid]){
                    left = mid;
                }else right = mid;
            }else if (nums[mid] == target) return mid;
        }


        //为什么需要两个判读？
        //因为当 left = 2 right = 3 时候；
        //mid 又会出现 = 2， 那么while就会卡死
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;

        return -1;
    }
}
public class MainClass {
    public static void main(String[] args) {

    }
}
