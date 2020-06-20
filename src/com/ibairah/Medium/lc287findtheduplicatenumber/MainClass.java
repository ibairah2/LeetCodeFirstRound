package com.ibairah.Medium.lc287findtheduplicatenumber;

/**
 * Created by ibairah on 6/19/20.
 *
 * Given an array nums containing n + 1 integers where each integer
 * is between 1 and n (inclusive), prove that at least one
 * duplicate number must exist. Assume that there is only one
 * duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be
 * repeated more than once.
 *
 */

class Solution {

    // Binary Search : O(nlogn) , O(1)
    public int findDuplicate(int[] nums) {
        int start = 1;  // 根据题意最小1  (1-n)
        int end = nums.length - 1;

        while(start< end){
            int mid = start + (end - start) / 2;

            //！！！关键： 创建一个count， 遍历数组，每有一个数大于target，count++；
            //假设n=10我选择mid=5。然后，我计算数组中所有小于等于的数字mid。如果存在多个小于的5数字5，其中一个发生了多次。
            //因此，我将搜索空间从缩小[1 10]到[1 5]。否则，重复的数字将在下半部分，因此对于下一步，搜索空间将为[6 10]
            int count = 0;
            for( int i = 0; i < nums.length; i++){
                if( nums[i] <= mid){
                    count++;
                }
            }
            if(count <= mid){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }
}
public class MainClass {
}
