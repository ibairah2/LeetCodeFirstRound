package com.ibairah.lc7ReverseInteger;

/**
 * Created by ibairah on 5/29/20.
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 −
 * 1]. For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 */


class Solution {
    //能用 但是有 Runtime Error ， 比如输入 1534236469，出现overflow
    public int reverse(int x) {
        int reversed = 0 ;
        int pop = 0;
        while( x != 0){
            pop = x%10;   //    123 / 10 = 12.....3 pop = 3
            x = x /10;    //    123 / 10 = 12       x = 12

        // 处理overflow
        //The biggest number an Integer can hold in space is 2147483647,
        //(Integer.MAX_VALUE / 10) is equal to 214748364,
        //so if the pop is more then 7 that means that an
        // Integer can't hold that amount of space.
        //The same logic goes into -8 which is Integer.MIN_VALUE.
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE/10 && pop > 7 )) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE/10 && pop < -8 )) return 0;

            reversed = (reversed * 10) + pop; // 第二轮loop reversed = 3*10 + 2 = 32
        }

        return reversed;
    }
}
public class MainClass {
    public static void main(String[] args) {
        int test1 = -123;
        Solution sl = new Solution();
        System.out.println(" sl.reverse(test1) :"+ sl.reverse(test1));
    }
}
