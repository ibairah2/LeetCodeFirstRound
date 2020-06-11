package com.ibairah.Medium.lc79WordSearch;

/**
 * Created by ibairah on 6/9/20.
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially
 * adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used
 * more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English
 * letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 */


class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        boolean[][] used = new boolean[board.length][board[0].length]; // 二维数组大小, 3行4列
        for( int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length;col++){
                if(helper(word.toCharArray(),board,0,row,col,used)){
                    return true;
                }
            }
        }
        return false;
    }

    // word改为char，这样后面word【idx】 不用再改变了
    private boolean helper(char[] word, char[][] board, int idx, int row, int col, boolean[][] used) {
        // exit

        if( idx == word.length) return true;

        // bound check
        if(row < 0 || row >= board.length || col<0 || col >=board[0].length) return false; //结束返回到上一层

        // current index not equal to word, or use used word
        if(used[row][col] == true || board[row][col] != word[idx]) return false; //结束返回到上一层

        // set to true because current word pass;
        used[row][col] = true;

        // right
        boolean exist = helper(word,board,idx+1,row,col+1,used);
        if(exist) return true;
        // left
        exist = helper(word,board,idx+1,row,col-1,used);
        if(exist) return true;
        // down
        exist = helper(word,board,idx+1,row+1,col,used);
        if(exist) return true;
        // up
        exist = helper(word,board,idx+1,row-1,col,used);
        if(exist) return true;

        //if 4 direction not found // 返回上一层，重新同样字符来开头
        used[row][col] = false;
        return false;
    }
}

public class MainClass {
}
