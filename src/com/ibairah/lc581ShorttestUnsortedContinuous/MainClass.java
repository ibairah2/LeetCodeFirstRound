package com.ibairah.lc581ShorttestUnsortedContinuous;

import java.util.Arrays;

/**
 * Created by ibairah on 5/25/20.
 * Given an integer array, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order, then the
 * whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 *        [2, 4, 6, 8, 9, 10, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending
 * order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here
 * means <=.
 *
 * [4,3,2,2,2,1,5]
 * output: 6
 */
public class MainClass {
    public static void main(String[] args) {
        int[] test = {2, 6, 4, 8, 10, 9, 15};
        Solution solution = new Solution();
        solution.findUnsortedSubarray4(test);
    }
}

class Solution {
    //!!!!最优解 Without Using Extra Space
    //T：O(nlogn)  S：O(1)
    public int findUnsortedSubarray4(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;

        // 找出第一个没有order的数
        for (int i = 1; i < nums.length; i++) { //从1开始因为要比较前一个数
            if (nums[i] < nums[i - 1])   //检查它的前一个数是否比它大 2,3
                flag = true; // 证明是有序的
            if (flag)  //false的情况出现第一个无序值，设这个位置的数为最小值；
                min = Math.min(min, nums[i]);
        }



        //从后往前遍历
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) //检查它的前一个数是否比它小 7.9
                flag = true;
            if (flag) //false的情况出现第一个无序值，设这个位置的数为最大值；
                max = Math.max(max, nums[i]);
        }

        //{2, 6, 4, 8, 10, 9, 15};
        //min :4   max :10
        //确定4和10应该在的位置，比如4找到比6小，则4应该在第6的位置，设为start
        System.out.println(" min :"+ min);

        int start, end;
        for (start = 0; start < nums.length; start++) {
            if (min < nums[start])
                break;
        }
        for (end = nums.length - 1; end >= 0; end--) {
            if (max > nums[end])
                break;
        }

        System.out.println(" start : "+ start);
        System.out.println(" end : "+ end);
        return (end - start >= 0 ? end - start + 1 : 0);
    }
    //最容易理解解法: 先sort，再对比两个array顺序，找出start & end 点
    //简化自己的办法 T：O(nlogn)  S：O(n)
    public int findUnsortedSubarray2(int[] nums) {
        int[] copy = nums.clone();  //复制array
        Arrays.sort(copy);  // 自动sort
        int ans;
        int start = nums.length+1 , end = 0; //设置开始为最大值
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != copy[i]){
                start = Math.min(start,i);  //!!!!简化关键
                end = Math.max(end,i);      //!!!!简化关键
            }
        }

        if(start == nums.length+1 && end == 0 ){
            ans =0;
        }else{
            ans = end-start+1;
        }

        return ans;
    }

    //自己的方法 Time；O(n) Space:O(n)
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();  //复制array
        int ans;
        Arrays.sort(copy);  // 自动sort
        int start = 0 , end = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != copy[i]){
                start = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i] != copy[i]){
                end = i;
                break;
            }
        }
        if(start == 0 && end == 0 ){
            ans =0;
        }else{
            ans = end-start+1;
        }
        return ans; // 因为是indices最后得+1；
    }



    // 暴力解法 列出所以continuous subarray 再找最短的
    public int findUnsortedSubarray3(int[] nums) {
        return 0;
    }
}
