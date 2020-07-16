package com.ibairah.Easy.lc680ValidPalindromeII;

/**
 * Created by ibairah on 2020/7/10.
 *
 * Given a non-empty string s, you may delete at most one character
 * . Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The
 * maximum length of the string is 50000.
 *
 */

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i <= j){
            // 如果出现不等，则再给一次机会，尝试左边删除一个，或者右边删除一个
            if(s.charAt(i) != s.charAt(j)){
                return helper(s,i+1,j)  || helper(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean helper(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

public class MainClass {
}
