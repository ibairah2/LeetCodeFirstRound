package com.ibairah.Medium.lc54SpiralMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ibairah on 6/8/20.
 * Given a matrix of m x n elements (m rows, n columns), return all
 * elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //corner case I:
        if(matrix.length == 0 || matrix[0].length == 0) return new LinkedList<Integer>();

        List<Integer> res = new LinkedList<Integer>();
        int top = 0;
        int bot = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;  // 一组数里有几个数


        while( left < right && top < bot){

            for( int i = left; i < right; i++){
                res.add(matrix[top][i]);
            }
            for( int i = top; i < bot; i++){
                res.add(matrix[i][right]);
            }
            for( int i = right; i > left; i--){
                res.add(matrix[bot][i]);
            }
            for( int i = bot; i > top; i--){
                res.add(matrix[i][left]);
            }

            top++;
            bot--;
            left++;
            right--;
        }

        // corner case    1. 中间剩竖着两个  2.中间剩横着两个  3.中间剩1个

        if( left == right ){
            for(int i = top; i <= bot; i++) res.add(matrix[i][left]);
        }
        else if ( top == bot){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
        }
        return res;

    }
}

public class MainClass {
}
