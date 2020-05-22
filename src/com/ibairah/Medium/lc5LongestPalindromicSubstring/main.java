package com.ibairah.Medium.lc5LongestPalindromicSubstring;

/**
 * Created by ibairah on 5/21/20.
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class main {
    public static void main(String[] args) {
        String s = "babad";
        Solution sl = new Solution();
        sl.longestPalindrome(s);
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start_pointer = 0;
        int end_pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            // 处理两种特殊情况，通过比较他们的长度来知道是哪一个例子
            int len1 = expandFromCenter(s, i, i); // 返回以1个字母中心的列子的最长长度 "racecar"
            int len2 = expandFromCenter(s, i, i + 1); // 返回以2个字母  "aabbaa,

            int len = Math.max(len1, len2); // 找出是哪一个例子，同时储存最长长度
            if (len > end_pointer - start_pointer) { // 更新最长长度
                // 更新start点，len-1的原因是 比如racecar长度为7，(7-1)/2为一半，
                //                              aabbaa长度为6，(6-1)/2=2，i+2，也能对应上起始点
                start_pointer = i - ((len - 1) / 2);
                end_pointer = i + len / 2;
            }
        }
        return s.substring(start_pointer,end_pointer+1);
    }
    public int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left-- ;
            right++;
        }
        //System.out.println(" right :" + right);
        //System.out.println(" left :" + left);
        return right - left + 1; // ！！！ 比如racecar长度为6 0 +1  =7；
    }
}
