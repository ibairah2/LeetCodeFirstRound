package com.ibairah.Medium.lc221MaximalSquare;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ibairah on 2020/7/14.
 * Given a 2D binary matrix filled with 0's and 1's, find the
 * largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row + 1][col + 1];

        int max = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    // 去看dp图中的1，对比如果左，上，对角都为1，则为1，否则为0；
                    // dp图中如果为2，则为2在+1；
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }
}



public class MainClass {
}
