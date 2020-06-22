package com.ibairah.Easy.lc130SurroundedRegions;

/**
 * Created by ibairah on 6/15/20.
 * Given a 2D board containing 'X' and 'O' (the letter O), capture
 * all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that
 * surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that
 * any 'O' on the border of the board are not flipped to 'X'. Any
 * 'O' that is not on the border and it is not connected to an 'O'
 * on the border will be flipped to 'X'. Two cells are connected if
 * they are adjacent cells connected horizontally or vertically.
 */

class Solution {
    public void solve(char[][] board) {
        // 1. corner case
        if(board == null || board.length == 0) return;

        //2. inital row and col
        int row = board.length;
        int col = board[0].length;

        //3. traverse first col and last col;找第一列和最后一列
        for(int i=0; i<row; i++){ // 小于多少行
            if(board[i][0] == 'O') dfs(i,0,board); // first col;
            if(board[i][col-1] == 'O') dfs(i,col-1,board);
        }

        //4. traverse row 第一列的和最后一列的值不断变化
        for(int j=0; j<col;j++){
            if(board[0][j] == 'O') dfs(0,j,board);
            if(board[row-1][j] == 'O') dfs(row-1,j,board);
        }

        //5. inverse all to make X to O, O to X;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }


    // dfs，搜索当前行列，如果搜到则搜索当前行列的的上下左右，如果还有
    // 则搜索上下左右的上下左右
    public void dfs(int i, int j, char[][] board){
        if (i<0 || j<0 || i>board.length-1 || j>board[0].length-1) return;
        if(board[i][j] != 'O') return;
        board[i][j] = 'A';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}




public class MainClass {
}
