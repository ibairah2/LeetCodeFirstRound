package com.ibairah.Medium.lc215KthLargestElementinanArray;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by ibairah on 6/17/20.
 *
 * Find the kth largest element in an unsorted array. Note that it
 * is the kth largest element in the sorted order, not the kth
 * distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

//https://www.youtube.com/watch?v=zyskis1Gw0c

    // 1。快排 2。PriorityQueue

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null ||nums.length == 0 || k < 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// 实现快排
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        //1. corner case
        if (nums == null || nums.length == 0 || k < 0) return 0;

        //2. randomize
        randomize(nums);

        //3. like binary search, set left, right, target
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k + 1; // find the Kth smallest;

        while (left <= right) {
            int pivotIdx = partition(nums, left, right);
            // get get answer
            if (target == pivotIdx + 1) {
                return nums[pivotIdx];
            } else if (target < pivotIdx) {
                right = pivotIdx - 1; // 如果target小于当前pivot，将右边界设为当前pivot的左边
            } else if (target > pivotIdx) {
                left = pivotIdx + 1; // 如果target大于当前pivot，将左边界设为当前pivot的右边
            }
        }
        return 0;
    }
    private void swap(int[] nums,int i ,int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 初始化，乱序化，从后往前随机交换
    private void randomize(int[] nums){
        Random rand = new Random();
        for(int i = nums.length -1; i> 0; i--){
            int r = rand.nextInt(i+1);
            swap(nums,i,r);
        }
    }

    //分割，设定pivot；
    private int partition(int[] nums,int left, int right){
        int pivot = right; // 永远将最右边的数设置为pivot
        int slow = left-1;
        int fast = left;
        while(fast < pivot){
            if(nums[fast] > nums[pivot]){
                fast++;
            }else{
                slow++;
                swap(nums,fast,slow);
                fast++;
            }
        }
        slow++;
        swap(nums,slow,pivot);
        return slow;
    }
}


public class MainClass {
}
