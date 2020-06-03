package com.ibairah.Medium.lc8StringtoInteger;

/**
 * Created by ibairah on 5/31/20.
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as
 * necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as
 * possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that
 * form the integral number, which are ignored and have no effect
 * on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not
 * a valid integral number, or if no such sequence exists because
 * either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is
 * returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 −
 * 1]. If the numerical value is out of the range of representable
 * values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is
 * the minus sign.
 *              Then take as many numerical digits as possible,
 *              which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character
 * is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is
 * not a numerical
 *              digit or a +/- sign. Therefore no valid conversion
 *              could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a
 * 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */


//I think we only need to handle four cases:
//
//1 discards all leading whitespaces
//2 sign of the number
//3 overflow
//4 invalid input

    //atoi - ascii to integer
class Solution {
    public int myAtoi(String str) {
       int index = 0;
        //1. remove white space
        while(index < str.length() && str.charAt(index)== ' '){
            index++;
        }
        //如果index==str，说明只有空格
        if(index == str.length()){
            return 0;
        }


        //2. Handle sign
        int sign = 1;
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            if(str.charAt(index) == '-'){
                sign = -1;
            }
            index++;
        }

        //如果index==str，说明只有符号
        if(index == str.length()){
            return 0;
        }


        //3. 处理结果
        int res = 0;
        while(index< str.length()){
            char c = str.charAt(index);
            if(c <'0' || c>'9'){ //当不在是数字的时候返回结果
                return res*sign;
            }

            int pop = c - '0';
            int temp = res * 10 + pop;
            if(temp/10 != res){
                return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = temp;
            index++;
        }
        return res*sign;
    }
}
public class MainClass {
    public static void main(String[] args) {

    }
}
