package com.ibairah.Medium.lc694NumberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ibairah on 6/24/20.
 * Given a non-empty 2D array grid of 0's and 1's, an island is a
 * group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the
 * grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to
 * be the same as another if and only if one island can be
 * translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not
 * consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not
 * exceed 50.
 */

// X = start
// O = out of bound Or water
// L = left
// R = right
// U = up
// D = down

class Solution {
    public int numDistinctIslands(int[][] grid) {
        // 1. corner case
        if(grid == null || grid.length == 0) return 0;

        //2. HashSet to store unique pathString
        Set<String> set = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    String path = computePath(grid,i,j,row,col,"X");
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    private String computePath(int[][] grid, int i, int j, int row, int col, String direction){
        //1. exit;
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0 ) return "O";

        // change current pos to 0
        grid[i][j] = 0;
        String left = computePath(grid,i,j-1,row,col,"L");
        String right = computePath(grid,i,j+1,row,col,"R");
        String up = computePath(grid,i-1,j,row,col,"U");  // 往上走第1行到第0行，-1
        String down = computePath(grid,i+1,j,row,col,"D");
        return direction + left + right + up + down;
    }
}

public class MainClass {
}
