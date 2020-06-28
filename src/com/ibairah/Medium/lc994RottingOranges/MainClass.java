package com.ibairah.Medium.lc994RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ibairah on 6/26/20.
 *
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent
 * (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no
 * cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2,
 * column 0) is never rotten, because rotting only happens
 * 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute
 * 0, the answer is just 0.
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */

//经典BFS模版
class Solution {
    //一维数组表达4个方向,以0，0为起点的，坐标轴
    //         a(0,1)
    //   d(-1,0)(0,0) b(1,0)
    //         c(0,-1)
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public int orangesRotting(int[][] grid) {
        //1.corner case
        if(grid == null || grid.length == 0) return -1;

        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        // count for fresh;
        int count = 0;

        //traverse to count fresh and put the rotting orange to queue
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //!!!!queue 添加二维数组
                if(grid[i][j] == 2) q.offer(new int[] {i,j});
                else if(grid[i][j] == 1) count++;
            }
        }

        //帮助提高速度的一个判断
        if(count == 0) return 0;

        int step = 0;
        //BSF
        while(!q.isEmpty()){
            step++;
            // check q size every time
            int size = q.size();
            // 遍历每一个烂橘子
            for(int i = 0; i < size; i++){
                int[] point = q.poll();
                //遍历这个点的四个方向
                for(int k = 0; k < 4; k++){
                    int x = point[0] + dx[k];
                    int y = point[1] + dy[k];
                    //check bound
                    if(x < 0 || y < 0 || x >= row || y >= col ||
                            grid[x][y] == 0 || grid[x][y] == 2) continue;
                    // change current fresh to rotting
                    grid[x][y] = 2;
                    // put to queue
                    q.offer(new int[] {x,y});
                    count--;
                }
            }
        }

        //记得step 需要 -1； 减去初始状态
        return count == 0 ? step - 1: -1;
    }

}
public class MainClass {
}
