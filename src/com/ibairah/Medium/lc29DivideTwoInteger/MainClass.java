package com.ibairah.Medium.lc29DivideTwoInteger;

/**
 * Created by ibairah on 6/28/20.
 * Given two integers dividend and divisor, divide two integers
 * without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means
 * losing its fractional part. For example, truncate(8.345) = 8 and
 * truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 −
 * 1]. For the purpose of this problem, assume that your function
 * returns 231 − 1 when the division result overflows.
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor >0)){
            sign = -1;
        }

        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);

        long res = 0;
        //被除数大于除数
        while(divid >= divis){
            long temp = divis;
            long power = 1;
            //如果当前被除数大于temp左移一位 = temp * 2
            // temp = 3 * 2 * 2
            // mul = 1 * 2 * 2
            while( divid >= (temp << 1)){
                temp <<= 1;
                power <<= 1;
            }

            res += power;
            //减去当前的结果，留下剩下的
            divid -= temp;
        }

        res = res * sign;

        return res >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}

public class MainClass {
}
