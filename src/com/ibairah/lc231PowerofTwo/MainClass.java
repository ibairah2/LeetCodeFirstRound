package com.ibairah.lc231PowerofTwo;

/**
 * Created by ibairah on 6/8/20.
 * Given an integer, write a function to determine if it is a power
 * of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */



class Solution {

    // Counting set bits

    // 如果说一个数是2的幂的话，结果一定是 1000.。。。。0；（只有1个1）
    //16 -> 10000
    //12 -> 1100

    public boolean isPowerOfTwo2(int n) {
        int count = 0;
        while ( n > 0 && count < 1){
            if( (n & 1)  == 1 ){
                count++;

            }
            n >>= 1;
        }
        return n == 1;
    }



    // T: O(logN)

    public boolean isPowerOfTwo(int n) {
        if( n == 0) return  false;

        // 4 / 2 = 2 , 2 / 2 = 1 ;
        // 6 / 2 = 3 , 3 / 2 = 1.....1;
        while( n % 2 == 0){
            n = n / 2 ;
        }

        return n == 1;
    }
}

public class MainClass {
}
