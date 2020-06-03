package com.ibairah.lc66PlusOne;

import java.util.Arrays;
import java.util.zip.GZIPInputStream;

/**
 * Created by ibairah on 6/2/20.
 * Given a non-empty array of digits representing a non-negative
 * integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at
 * the head of the list, and each element in the array contain a
 * single digit.
 *
 * You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

//https://www.youtube.com/watch?v=G737jzcxG9A

// [1,2,9]-->[1,3,0]      [9,9,9]-->[1,0,0,0]
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >=0; i --){
            if( digits[i] < 9 ){
                digits[i] += 1;
                return digits;
            }
            // 如果出现9的情况
            //[1,2,3,9,9] -->  [1,2,4,0,0];
            digits[i] = 0;
        }

        // [9,9,9]
        int[] newNumber = new int[digits.length+1];
        newNumber[0] = 1;
        return newNumber;
    }
}


public class MainClass {
    public static void main(String[] args) {
        int[] test = {4,3,2,1};
        int[] test2 = {9}; // [1,0]
        Solution solution = new Solution();
        solution.plusOne(test);
        solution.plusOne(test2);
    }
}
