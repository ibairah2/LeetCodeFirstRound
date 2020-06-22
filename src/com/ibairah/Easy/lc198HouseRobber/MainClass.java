package com.ibairah.Easy.lc198HouseRobber;

import java.io.IOException;

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
    //理解
    public int rob6(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

    // Dp 更好理解的办法

    public int robez(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        //Initialize an arrays to store the money
        int[] mark = new int[nums.length];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]); //从开始两个选择较大一个数

        for(int i=2;i<nums.length;i++){
            // 本题的情况， 对比如果我这次rob那我再 + 上上次rob的钱，是否比我
            // 上一次rob钱更多，i=2,nums[i] = 5->> 1, 10, 5 ->>  5 + 1 < 10
            mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
        }
        return mark[nums.length-1];
    }


    //DP
    //Time: O(n) Space:O(1)
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i]+dp[i-1], dp[i]);
        }

        return dp[nums.length]; // dp最后一位则是最大和
    }



    // 使用recursive
    //我当前房子+我上一个隔开的房子（i-2）的钱  VS  我上一个房子钱（i-1）
    //哪一个大则选择哪一个
    //Time: O(n) Space:O(n)
    public int robrc(int[] nums) {
        return robrc(nums, nums.length - 1);
    }
    private int robrc(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(robrc(nums, i - 2) + nums[i], robrc(nums, i - 1));
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
