package com.ibairah.Medium.lc151ReverseWordsinAString;

/**
 * Created by ibairah on 2020/7/16.
 *
 * Given an input string, reverse the string word by word.
 *
 *  
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or
 * trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two
 * words to a single space in the reversed string.
 *  
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However,
 * your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 *  
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 */

class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--){

            //！！！！String 必须用equals， 如果用== 则会无效
            if(str[i].equals("")) continue;
            res.append(str[i] + " ");
        }
        return res.toString().trim();
    }
}

public class MainClass {
}
