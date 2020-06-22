package com.ibairah.Easy.lc867TransposeMatrix;

import java.util.Arrays;

/**
 * Created by ibairah on 6/4/20.
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main
 * diagonal, switching the row and column indices of the matrix.
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */


class Solution {
    public int[][] transpose(int[][] A) {
      /*
       [
        [1,2,3],
        [4,5,6],
        [7,8,9],
        [10,11,12]
       ]
       */

        int rows =A.length;
        int cols =A[0].length;
        System.out.println(" A :"+ Arrays.deepToString(A));   // 4排
        System.out.println(" A[0] :"+ Arrays.toString(A[0])); // 3列
        System.out.println(" rows :"+ rows);
        System.out.println(" cols :"+ cols);

        int[][] new_matrix = new int[cols][rows];

        for( int r = 0; r < rows; r++){
            for ( int c = 0; c<cols; c++){
                new_matrix[c][r] = A[r][c];
            }
        }
        return new_matrix;
    }
}


public class MainClass {
    public static void main(String[] args) {
        int[][] test ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        Solution solution = new Solution();
        solution.transpose(test);
    }
}
