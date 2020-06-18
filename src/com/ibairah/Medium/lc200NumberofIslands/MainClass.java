package com.ibairah.Medium.lc200NumberofIslands;

/**
 * Created by ibairah on 6/17/20.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the
 * number of islands. An island is surrounded by water and is
 * formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by
 * water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    counter++;
                    BFS(i,j,grid);
                }
            }
        }
        return counter;
    }

    public void BFS(int i, int j, char[][] grid){
        // bound check
        if(i<0 || j<0 || i>grid.length-1 || j > grid[0].length-1 || grid[i][j] == '0') return;

        // set current 1 to 0;
        grid[i][j] = '0';

        // bfs check current surround
        BFS(i+1,j,grid);
        BFS(i-1,j,grid);
        BFS(i,j+1,grid);
        BFS(i,j-1,grid);
    }

}

public class MainClass {
}
