package com.ibairah.Medium.lc34FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

/**
 * Created by ibairah on 6/3/20.
 * Given an array of integers nums sorted in ascending order, find
 * the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O
 * (log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

class Solution {

    //最优，最好理解
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        res[0] = findStartPoint(nums,target);
        res[1] = findEndPoint(nums,target);
        return res;
    }

    private int findStartPoint(int[] nums, int target) {
        int start = 0 , end = nums.length-1, start_point = -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            // target 小于 mid 右指针移动
            // 1. 找起点时候，不断往左移动
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target) start_point =  start;
        else if(nums[end] == target) start_point = end;
        return start_point;
    }

    private int findEndPoint(int[] nums, int target) {
        int start = 0 , end = nums.length-1,end_point=-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            // 2. 找终点，不断往右移动
            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target) end_point = end;
        else if(nums[start] == target) end_point = start;
        return end_point;
    }

    // ------------------- Method 2 -------------------
    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1,-1};
        res[0] = findStartPoint2(nums,target);
        res[1] = findEndPoint2(nums,target);
        System.out.println("res  :"+ Arrays.toString(res));
        return res;
    }

    private int findStartPoint2(int[] nums, int target) {
        int res = -1;

        int start = 0;
        int end = nums.length-1;
        System.out.println("target: "+ target);
        while(start<=end){
            int midpoint = start + (end - start)/2;
            System.out.println(" nums[midpoint]: "+nums[midpoint] );
            System.out.println(" midpoint: "+midpoint );

            //// 关键逻辑
            System.out.println(" Start start :"+start );
            System.out.println(" Start end :"+end );
            if(nums[midpoint] >= target){
                end = midpoint - 1;
                System.out.println(" Start if end update:"+end );
            }else{
                start = midpoint + 1;
                System.out.println(" Start if start update:"+start );
            }
            ////
            if(nums[midpoint] == target) {
                res = midpoint;
                System.out.println(" res update  :"+ res);

            }
        }
        System.out.println("---------Divided Line-----------" );
        return res;
    }

    private int findEndPoint2(int[] nums, int target) {
        int res = -1;

        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int midpoint = start + (end - start)/2;
            //// 关键逻辑
            System.out.println(" End start :"+start );
            System.out.println(" End end :"+end );
            if(nums[midpoint] <= target){
                start = midpoint + 1;
                System.out.println(" if End start update:"+start );
            }else{
                end = midpoint - 1;
                System.out.println(" if End end update:"+end );

            }
            ////
            if(nums[midpoint] == target) res = midpoint;
        }
        return res;
    }
}


class Solution2{
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0) return res;
        res[0] = findStart(nums,target);
        res[1] = findEnd(nums,target);
        System.out.println(" res :"+ Arrays.toString(res));
        return res;
    }

    public int findStart(int[] nums, int target){
        int res = -1;

        // binary search
        int start = 0;
        int end = nums.length-1;


        while(start + 1 < end){
            int mid = start + (end - start)/2 ;// overflow
            if(target <= nums[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target) res = start;
        if(nums[end] == target) res = end;
        //
        return res;
    }

    public int findEnd(int[] nums, int target){
        // binary search
        int start = 0, end = nums.length-1,res = -1 ;

        while(start + 1 < end){
            System.out.println("in while");
            int mid = start + (end - start)/2 ; // overflow
            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(nums[end] == target) res = end;
        else if(nums[start] == target) res = start;
        //
        return res;
    }
}

public class MainClass {
    public static void main(String[] args) {
        //nums = [5,7,7,8,8,10], target = 8
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
     //   Solution solution = new Solution();
     //   solution.searchRange(nums,target);

        Solution2 solution2 = new Solution2();
        solution2.searchRange(nums,target);
    }
}
