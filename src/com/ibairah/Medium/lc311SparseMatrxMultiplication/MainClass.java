package com.ibairah.Medium.lc311SparseMatrxMultiplication;

/**
 * Created by ibairah on 6/29/20.
 *
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 *
 * Input:
 *
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 *
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *
 * Output:
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 *
 *
 * Constraints:
 *
 * 1 <= A.length, B.length <= 100
 * 1 <= A[i].length, B[i].length <= 100
 * -100 <= A[i][j], B[i][j] <= 100
 */
// 修改版本，先判断是否为0
// 矩阵相乘
// 结果为 A的行数 与 B的列数
class Solution2 {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null) return null;

        int Al = A.length;
        int A0 = A[0].length;
        int B0 = B[0].length;
        //A的行数 与 B的列数
        int[][] res = new int[Al][B0];

        for(int i = 0; i < Al; i++){
            for(int k = 0; k < A0; k++){
                //先判断是否为0
                if(A[i][k] != 0){
                    for(int j = 0; j < res[0].length; j++){
                        //先判断是否为0
                        if(B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }

            }
        }
        return res;
    }
}

// brute force
// 矩阵相乘
// 结果为 A的行数 与 B的列数
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null) return null;

        //A的行数 与 B的列数
        int[][] res = new int[A.length][B[0].length];

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                for(int k = 0; k < A[0].length; k++){
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }
}
public class MainClass {
}
