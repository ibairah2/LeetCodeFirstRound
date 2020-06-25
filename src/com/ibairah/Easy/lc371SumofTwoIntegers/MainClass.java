package com.ibairah.Easy.lc371SumofTwoIntegers;

/**
 * Created by ibairah on 6/23/20.
 * Calculate the sum of two integers a and b, but you are not
 * allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 */

class Solution {
    public int getSum(int a, int b) {
        //当还存在进位的情况
        while( b != 0){
            // 比如 101 & 110 = 100， 左移一位后变为1000
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
public class MainClass {
}
