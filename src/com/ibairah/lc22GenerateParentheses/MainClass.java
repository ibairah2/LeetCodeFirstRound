package com.ibairah.lc22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/1/20.
 * Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

//https://www.youtube.com/watch?v=qBbZ3tS0McI
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,n,"",0,0);
        return res;
    }

    public void backtrack(List<String> res, int n, String current_string,
                          int open_p, int close_p ){
        if(current_string.length() == n*2){ // 一个n代表一对
            res.add(current_string);
            return;
        }
        if(open_p < n){ // 当（ 还未达到要求数量时候
                        //current_string+"(", 需要包括之前的括号一起
            backtrack(res,n,current_string+"(",open_p+1, close_p);
        }
        if(close_p < open_p){ // " ）"不能在"（ "之前
            backtrack(res,n,current_string+")",open_p, close_p+1);
        }
    }
}



public class MainClass {
    public static void main(String[] args) {
        int test = 3;
        Solution solution = new Solution();
        solution.generateParenthesis(test);
    }
}
