package com.ibairah.Medium.lc1060MissingElementinSortedArray;

/**
 * Created by ibairah on 2020/7/12.
 *
 * Given a sorted array A of unique numbers, find the K-th missing
 * number starting from the leftmost number of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 * Example 2:
 *
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing
 * number is 8.
 * Example 3:
 *
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing
 * number is 6.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 */

class Solution {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(k == 0) return nums[0];

        int start = 0, end = nums.length;
        while(start + 1< end){
            int mid = start  + (end - start)/2;
            //如果差的个数小于k说明，missing number在mid的右边
            if(missingCount(nums,mid) < k) start = mid ;
            else end = mid;
        }
        System.out.println("start :"+ start);
        System.out.println("nums[start]  :"+ nums[start]);
        System.out.println("missingCount(nums,start-1)  :"+ missingCount(nums,start));
        System.out.println(nums[start] + k - missingCount(nums,start));
        return nums[start] + k - missingCount(nums,start);
    }

    // # [4,7,9,10]
    // #    |
    // #    1
    // # 7 - 4 - 1 == 2

    // # [4,7,9,10]
    // #      |
    // #      2
    // # 9 - 4 - 2 = 3   num_missing between 0 and i is: nums[i] - nums[0] - i

    private int missingCount(int nums[], int i){
        return nums[i] - nums[0] - i;
    }
}
public class MainClass {
    public static void main(String[] args) {
        int[] A = {4,7,9,10};
        int[] B ={1,2,4};
        int k = 3;
        Solution solution = new Solution();
        solution.missingElement(A,k);
        solution.missingElement(B,k);

    }
}
