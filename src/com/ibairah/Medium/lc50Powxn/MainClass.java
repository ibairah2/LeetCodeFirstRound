package com.ibairah.Medium.lc50Powxn;

/**
 * Created by ibairah on 6/7/20.
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

class Solution {
    // Binary Search
    // 1.奇偶 2.正负 3. 处理Math.MIN_VALUE，
    public double myPow(double x, int n) {
        //corner case
        if(n == 0 || x == 1 ) return 1;
        if(n == 1 ) return x;

        System.out.println(" 1 :"+ 1);

        // deal Min_value && +-
        if( n < 0) {
            return 1 /(x*myPow( x ,-(n+1)));  // power + 1, 为了补这一个1，多乘一个x
        }

        double res = 1;
        while( n > 1){
            System.out.println(" 2 :"+ 2);
            if( n % 2 == 1){
                res = res * x;
            }
            x = x * x;
            System.out.println(" x :"+ x);
            n = n /2;
        }
        res = res * x;
        System.out.println(" res :"+ res);
        return res;
    }


    //暴力解
    // 这种题关键步骤在于 如何处理 overflow ，long型
    public double myPow2(double x, int n) {
        double  res = 1;

        if ( n == 0 ) return 1;
        if ( n < 0 ){
            x = 1/x;
            long len = Math.abs(n);
            for( long i = 0; i < len; i++){
                res = res * x;
            }
            System.out.println(" res neg :"+ res);
            return res;
        }

        for( long i = 0; i < n; i++){
            //结果每次 * x
            // 1 * 2 = 2 -> 2 * 2 = 4 -> 4 * 2 = 8
            res = res * x ;
        }
        System.out.println(" res :"+ res);
        return res;
    }
}

public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myPow(3,4);
        solution.myPow(2,-2);
        solution.myPow(1, 2147483647);
    }
}
