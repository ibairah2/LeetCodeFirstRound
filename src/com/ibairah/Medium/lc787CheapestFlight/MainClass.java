package com.ibairah.Medium.lc787CheapestFlight;

import java.util.Arrays;

/**
 * Created by ibairah on 6/14/20.
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int K) {
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[K+2][n];

        for(int i = 0; i< K + 2; i++){
            Arrays.fill(dp[i],max);
        }

        dp[0][src] = 0 ; // move 0 step

        for( int i = 1; i <= K + 1 ; ++i){
            dp[i][src] = 0;  //
            for( int[] flight: flights){
                // 我用了i步飞到了flight[1]
                // 现在的dp 闭上之前一步+当前的cost
                dp[i][flight[1]] = Math.min(dp[i][flight[1]],
                        dp[i-1][flight[0]]+ flight[2]);
            }
        }

        //System.out.println("dp[K+1][dst]: " + dp[K+1][dst]);
        return dp[K+1][dst] >= max ? -1 : dp[K+1][dst];
    }
}



class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 停靠k站，应该变为k+1
        // dp[n][K + 1]
        // 1. dp status: dp[s][k + 1] : from s, stop k , find the min cost arrive dst;
        // 2. egde case: dp[dst][0], dst start, not do anything;
        // 3. transfer function: dp[s][k+1] = min{cost[s->s'] + dp[s'][k-1]} k-1因为已经停靠了s‘站

        //1. initial
        int[][] dp = new int[n][K + 2];
        for(int i = 0; i < n; i ++){
            // initial as -1, because if not exist any path
            Arrays.fill(dp[i],-1);
        }

        //2. edge case:
        dp[dst][0] = 0;

        //3. transfer function:
        for( int k = 0; k < K + 1; k++){
            // only care the city in flights
            for( int[] f: flights){
                int start_city = f[0];
                int end_city = f[1];
                int cost = f[2];
                // s' to k not exist, no update
                if( dp[end_city][k] == -1) continue;

                // 存在一个s‘到k的最小价格，更新结果
                if(dp[start_city][k+1] == -1) {
                    dp[start_city][k+1] = dp[end_city][k] + cost;
                }
                dp[start_city][k+1] = Math.min(dp[start_city][k+1],dp[end_city][k] + cost);

            }
        }

        // Find the min cost,  dp[start][0->K+1] 中最小的那一个
        int min = -1;
        for( int k = 0; k <= K+1; k++){
            if(dp[src][k] != -1){
                min = min ==-1 ? dp[src][k] : Math.min(min,dp[src][k]);
            }
        }
        return min;
    }
}
public class MainClass {
}
