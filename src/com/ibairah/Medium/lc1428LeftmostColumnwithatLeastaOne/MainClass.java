package com.ibairah.Medium.lc1428LeftmostColumnwithatLeastaOne;

/**
 * Created by ibairah on 2020/7/12.
 */

import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */


/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */


// 题意：返回最左边包含至少一个1的那一列的index
//class Solution {
//    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//        List<Integer> dimen = binaryMatrix.dimensions();
//        int m = dimen.get(0), n = dimen.get(1);
//        int row = 0; int col = n - 1;
//        int lastCol = -1;
//
//        while(row < m && col >= 0){
//            if(binaryMatrix.get(row,col) == 1){
//                // 更新结果，记录当前col
//                lastCol = col;
//                col--;
//            }else{
//                //取下一行寻找
//                row++;
//            }
//        }
//
//        return lastCol;
//    }
//}
public class MainClass {
}
