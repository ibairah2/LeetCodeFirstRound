package com.ibairah.Medium.lc322CoinChange;

/**
 * Created by ibairah on 6/7/20.
 * You are given coins of different denominations and a total
 * amount of money amount. Write a function to compute the fewest
 * number of coins that you need to make up that amount. If that
 * amount of money cannot be made up by any combination of the
 * coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of
 * coin.
 */



// 322 和 518区别:
//    322 找出使用最少的硬币完成，518是列出所有的可能性

class Solution {

    //#Recursive Method:#
    //The idea is very classic dynamic programming: think of the
    // last step we take. Suppose we have already found out the
    // best way to sum up to amount a, then for the last step, we
    // can choose any coin type which gives us a remainder r where
    // r = a-coins[i] for all i's. For every remainder, go through
    // exactly the same process as before until either the
    // remainder is 0 or less than 0 (meaning not a valid solution)
    // . With this idea, the only remaining detail is to store the
    // minimum number of coins needed to sum up to r so that we
    // don't need to recompute it over and over again.
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed

        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse


        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    //#Iterative Method:#
    //For the iterative solution, we think in bottom-up manner.
    // Suppose we have already computed all the minimum counts up
    // to sum, what would be the minimum count for sum+1?
    public int coinChange2(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 1;

        while(sum <= amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    if (min < 0 || temp < min)
                        min = temp;
                }
            }
            dp[sum] = min;
            sum++;
        }
        return dp[amount];
    }
}

public class Mainclass {
}
