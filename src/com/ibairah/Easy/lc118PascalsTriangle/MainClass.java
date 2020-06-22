package com.ibairah.Easy.lc118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/10/20.
 * Given a non-negative integer numRows, generate the first numRows
 * of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers
 * directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * Accepted
 * 367,692
 * Submissions
 * 713,663
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if( numRows == 0) return res;

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        res.add(first_row);

        // loop多少行
        for( int i = 1; i < numRows; i++){
            List<Integer> prev_row = res.get(i-1);
            System.out.println("prev_row  :"+ prev_row);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1; j < i; j++){
                row.add(prev_row.get(j-1) + prev_row.get(j));
            }

            row.add(1);
            res.add(row);
        }
        return res;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
    }
}
