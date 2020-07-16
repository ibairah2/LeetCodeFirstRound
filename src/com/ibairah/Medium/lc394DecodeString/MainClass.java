package com.ibairah.Medium.lc394DecodeString;

import java.util.Stack;

/**
 * Created by ibairah on 2020/7/15.
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the
 * encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive
 * integer.
 *
 * You may assume that the input string is always valid; No extra
 * white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not
 * contain any digits and that digits are only for those repeat
 * numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> result = new Stack();

        String res = " ";
        int index = 0;

        while (index < s.length()){
            if (Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10*count +(s.charAt(index)-'0');
                    index+=1;
                }
                counts.push(count);
            }

            else if(s.charAt(index)=='['){
                result.push(res);
                res=" ";
                index+=1;
            }

            else if(s.charAt(index)==']'){
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();

                for (int i= 0 ;i<count ;i++){
                    temp.append(res);
                }

                res= temp.toString();
                index=+1;

            }
            else{
                res+= s.charAt(index);
                index+=1;
            }
        }


        return res;
    }
}

public class MainClass {
}
