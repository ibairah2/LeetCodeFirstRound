package com.ibairah.lc198HouseRobber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ibairah on 5/24/20.
 * You are a professional robber planning to rob houses along a
 * street. Each house has a certain amount of money stashed, the
 * only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were
 * broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of
 * money of each house, determine the maximum amount of money you
 * can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money
 * = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9)
 * and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */

class Solution {

    //DP
    //Time: O(n) Space:O(1)
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[1];

        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i]+dp[i-1], dp[i]);
        }

        return dp[nums.length]; // dp最后一位则是最大和
    }

    // 使用recursive
    //我当前房子+我上一个隔开的房子（i-2）的钱  VS  我上一个房子钱（i-1）
    //哪一个大则选择哪一个
    //Time: O(n) Space:O(n)
    public int rob2(int[] nums) {
        return 0;
    }

    //迭代方法 类似DP
    public int rob3(int[] nums){
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int curr = 0;
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

}

public class MainClass {
    public static void main(String[] args) throws IOException {
        int[] test = {1,2,3,1};
        Solution sl = new Solution();
        sl.rob(test);
        System.out.println(" ans :"+ sl.rob(test));
    }
}
