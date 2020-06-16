package com.ibairah.Medium.lc150EvaluateReversePolishNotaion;

import java.util.Stack;

/**
 * Created by ibairah on 6/16/20.
 * Evaluate the value of an arithmetic expression in Reverse Polish
 * Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer
 * or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the
 * expression would always evaluate to a result and there won't be
 * any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17",
 * "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */


// https://www.youtube.com/watch?v=6FCyyrrtjp0
// Stack思想
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            // "+"
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            // "-"
            else if(s.equals("-")){
                stack.push(-(stack.pop() - stack.pop()));
            }
            // "*"
            else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            // "/"
            else if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
                //stack.push(1/(stack.pop()/stack.pop())); // 会导致被除数为0
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}

public class MainClass {
}
