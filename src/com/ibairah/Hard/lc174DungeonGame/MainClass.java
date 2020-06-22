package com.ibairah.Hard.lc174DungeonGame;

/**
 * Created by ibairah on 6/21/20.
 * The demons had captured the princess (P) and imprisoned her in
 * the bottom-right corner of a dungeon. The dungeon consists of M
 * x N rooms laid out in a 2D grid. Our valiant knight (K) was
 * initially positioned in the top-left room and must fight his way
 * through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive
 * integer. If at any point his health point drops to 0 or below,
 * he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses
 * health (negative integers) upon entering these rooms; other
 * rooms are either empty (0's) or contain magic orbs that increase
 * the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the
 * knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial
 * health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the
 * knight must be at least 7 if he follows the optimal path RIGHT->
 * RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room
 * the knight enters and the bottom-right room where the princess
 * is imprisoned.
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //dp[i][j]: 从i，j出发需要的最小初始血量；
        //1.我希望我的初始血量+dungeon对我的影响是可以满足，往下或者往右的最小血量要求：
        //dp[i][j] +  dungeon[i][j] >= min{dp[i+1][j],dp[i][j+1]}
        //2.移项 ：
        //dp[i][j] = min{dp[i+1][j]-dungeon[i][j],dp[i][j+1]-dungeon[i][j]}
        //3.⚠️注意需要满足大于等于1:
        //dp[i][j] = max{1,min{dp[i+1][j]-dungeon[i][j],dp[i][j+1]-dungeon[i][j]}}
        //4.到达的时候需要满足血量大于等于1:
        //dp[n][m] = max{1,1-dungeon[n][m]}

        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int [n][m];

        //1.因为由i+1，j+1推出i，j，所以遍历从大到小求解，而且是为了求出发位置
        for(int i = n-1; i >= 0; i--){
            for(int j = m- 1; j>= 0; j--){
                //2.corner case
                if(i == n - 1 && j == m - 1){
                    dp[i][j] = Math.max(1,1-dungeon[i][j]);
                    continue;
                }
                int min = Integer.MAX_VALUE;
                //3. if we can move down
                if( i + 1 < n){
                    min = dp[i+1][j] - dungeon[i][j];
                }
                //4. if we can move right
                if(j + 1 < m){
                    min = Math.min(min,dp[i][j+1]-dungeon[i][j]);
                }
                //5. compare min and 1 to find the max_value;
                dp[i][j] = Math.max(1,min);
            }
        }
        //6. return the initial position
        return dp[0][0];
    }
}
public class MainClass {
}
