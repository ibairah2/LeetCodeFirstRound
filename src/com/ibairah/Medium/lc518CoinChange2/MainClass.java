package com.ibairah.Medium.lc518CoinChange2;

/**
 * Created by ibairah on 6/7/20.
 * You are given coins of different denominations and a total
 * amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you
 * have infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins
 * of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Note:
 *
 * You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */


// f(n,amount)  用n种硬币组成amount的方法数
// --> 推状态转移的方程 ：f(i,j) = f(i-1,j) + f(i,j-coins[i])
    //                       不使用当前i硬币 + 使用当前i硬币，则jamount需要减去当前i硬币
// --> 查看边界条件：f(i,0) = 1


//This is a classic knapsack problem. Honestly, I'm not good at
// knapsack problem, it's really tough for me.
//
//dp[i][j] : the number of combinations to make up amount j by
// using the first i types of coins
//State transition:
//
//not using the ith coin, only using the first i-1 coins to make up
// amount j, then we have dp[i-1][j] ways.
//using the ith coin, since we can use unlimited same coin, we need
// to know how many ways to make up amount j - coins[i-1] by using
// first i coins(including ith), which is dp[i][j-coins[i-1]]
//
//Initialization: dp[i][0] = 1
//
//Once you figure out all these, it's easy to write out the code:

class Solution {
    public int change(int amount, int[] coins) {
        // initial
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for( int i =1 ; i< coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j < amount; j++){
                dp[i][j] += dp[i-1][j];
                if(j >= coins[i-1]){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
public class MainClass {
}
