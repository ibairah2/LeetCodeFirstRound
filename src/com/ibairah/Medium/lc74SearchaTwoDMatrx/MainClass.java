package com.ibairah.Medium.lc74SearchaTwoDMatrx;

/**
 * Created by ibairah on 6/19/20.
 *
 * Write an efficient algorithm that searches for a value in an m x
 * n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer
 * of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col -1;

        while( start + 1 < end){
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+ mid);
            // 找到在二维数组中的中间数！！！！
            int midElement = matrix[mid/col][mid%col];
            System.out.println("midElement: "+ midElement);
            if(target > midElement){
                start = mid;
            }else if (target < midElement){
                end = mid;
            }else{
                return true;
            }
        }

        // deal start and end point;
        if(matrix[start/col][start%col] == target){
            return true;
        }
        if(matrix[end/col][end%col] == target){
            return true;
        }
        else{
            return false;
        }

    }
}
//[[1,   3,  5,  7, 8],[10, 11, 16, 20, 21],[23, 30, 34, 50, 53],[60, 62, 65, 78, 88]]
//3

// target = 0

public class MainClass {
}