package com.ibairah.Medium.lc73SetMatrixZeroes;

/**
 * Created by ibairah on 6/8/20.
 *
 * Given a m x n matrix, if an element is 0, set its entire row and
 * column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]f
 * ]
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad
 * idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) return;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check first row include 0 or not
        for( int i=0 ; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        // check first col include 0 or not
        for( int i=0 ; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstColZero = true;
                break;
            }
        }

        // set out row and col to zero
        for( int row=1; row<matrix[0].length; row++){
            for(int col=1; col<matrix.length;col++){
                if(matrix[col][row] == 0){
                    matrix[col][0] = 0;
                    matrix[0][row] = 0;
                }
            }
        }

        // heck if
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0 ){
                for(int j = 1; j < matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0 ){
                for(int j = 1; j < matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero){
            for ( int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColZero){
            for ( int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
public class MainClass {
}
