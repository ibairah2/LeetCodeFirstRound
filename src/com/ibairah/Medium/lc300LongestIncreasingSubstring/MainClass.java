package com.ibairah.Medium.lc300LongestIncreasingSubstring;

import java.util.Arrays;

/**
 * Created by ibairah on 6/20/20.
 * Given an unsorted array of integers, find the length of longest
 * increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101],
 * therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary
 * for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */


//https://www.youtube.com/watch?v=5rfZ4Wn
// 二分法 + DP， 将最小的数排在前面，每有一个数小于前一个数，则更新
//1. new int[]
//2. 10
//3. 10 > 9; => 9
//4. 9 > 2; => 2
//5. 2 < 5; => 2,5
//6. 5 > 3; => 2,3
//7. 3 < 7; => 2,3,7
//8. 7 < 101; => 2,3,7,101
//9. 101 > 18; => 2,3,7,18
// 只有放在最后的时候， new int的length++，其他则在内部更新

/*
1, traverse from 0 to len-1, the DP array keep the longest sequence.
2, if the val is bigger than largest in the dp array, add it to the end;
3, if it is among the sequence, return the pos that bigger than pres, update the array with this position if val is smaller than dp[pos];
This is to keep the sequence element with the smallest number.
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        //1. corner case;
        if(nums==null || nums.length == 0) return 0;

        //2.create new int[] array;
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // set the first element as the start number;
        int len = 0;

        //3. traverse nums and update dp's element
        for(int i = 1; i < nums.length; i++){
            System.out.println("---------New loop i: " + i);
            System.out.println("dp before binarySearch:"+ Arrays.toString(dp));
            int pos = binarySearch(dp,len,nums[i]);
            System.out.println("pos :"+ pos);

            // 如果当前值小于dp中的当前值，dp当前值更新
            if(nums[i] < dp[pos]){
                dp[pos] = nums[i];
            }
            System.out.println("len :"+ len);
            //4. update current position && put nums[i] to next position;
            if(pos > len){
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len+1;
    }
    private int binarySearch(int[] dp, int len, int cur_nums){
        int start = 0;
        int end = len;
        System.out.println("--binarySearch--");
        System.out.println("dp :"+ Arrays.toString(dp));
        System.out.println("cur_nums :"+ cur_nums);
        System.out.println("right :"+ end);
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            System.out.println("mid :"+ mid);
            if(dp[mid] == cur_nums){
                return mid;
            }else if(dp[mid] < cur_nums){
                start = mid;
            }else{
                end = mid;
            }
        }
        System.out.println("dp[start] :"+ dp[start]);
        System.out.println("dp[end] :"+ dp[end]);
        // deal start and end point;
        if(dp[start] >= cur_nums) {
            return start;
        }
        else if (dp[end] > cur_nums){
            return end;
        }
        else
            System.out.println("--end binarySearch Line--" );
            return len + 1;

    }
}

public class MainClass {
    public static void main(String[] args) {
        int[] test = {10,9,2,5,3,7,101,18};
        Solution solution = new Solution();
        solution.lengthOfLIS(test);
    }
}
