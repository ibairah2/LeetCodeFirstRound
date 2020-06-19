package com.ibairah.Medium.lc227BasicCalculatorII;

import java.util.Stack;

/**
 * Created by ibairah on 6/18/20.
 *
 * Implement a basic calculator to evaluate a simple expression
 * string.
 *
 * The expression string contains only non-negative integers, +, -,
 * *, / operators and empty spaces . The integer division should
 * truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int temp_number = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // 1. meet digit number
            if(Character.isDigit(c)){
                temp_number =temp_number * 10 +  c - '0'; // temp_number * 10 是为了只有数字的情况
            }

            //2. meet sign
            //！！！！关键 ： i == s.length() -1
            if(c != ' ' && !Character.isDigit(c) || i == s.length() -1){
                if(sign == '+'){
                    stack.push(temp_number);
                }else if(sign == '-'){
                    stack.push(-temp_number);
                }else if(sign == '*'){     // 乘除法优先级高，所以需要提取前一个数字来乘除再push入stack
                    stack.push(stack.pop() * temp_number);
                }else if(sign == '/'){
                    stack.push(stack.pop() / temp_number);
                }

                sign = c;
                temp_number = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}


public class MainClass {
}
