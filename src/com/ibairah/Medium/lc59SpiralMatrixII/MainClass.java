package com.ibairah.Medium.lc59SpiralMatrixII;

/**
 * Created by ibairah on 6/8/20.
 *
 * Given a positive integer n, generate a square matrix filled with
 * elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */


class Solution {
    public int[][] generateMatrix(int n) {
        //corner case I:
        int[][] res = new int[n][n];
        int k = 1;

        int top = 0;
        int bot = n - 1;
        int left = 0;
        int right = n - 1;
        while( left < right && top < bot ){
            for( int i = left; i < right; i++){
                res[top][i] = k++;
            }
            for( int i = top; i< bot; i++){
                res[i][right] = k++;
            }
            for( int i = right; i > left; i--){
                res[bot][i] = k++;
            }
            for( int i = bot; i > top; i--){
                res[i][left] = k++;
            }
            top++;
            bot--;
            left++;
            right--;
        }


        // corner case II : odd n will occur extra single number
        if( n % 2 == 1) {
            res[n/2][n/2] = k++;
        }

        return res;
    }
}
public class MainClass {
}
