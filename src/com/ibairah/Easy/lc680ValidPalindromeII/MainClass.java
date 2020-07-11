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

        for(int i = 0; i < s.length(); i++){
            s = s.substring(i);
        }
        return isPalidram(s);
    }

    private boolean isPalidram(String s){
        char[] c = s.toCharArray();
        int pointerA = 0;
        int pointerB = s.length();

        while(pointerA < pointerB){
            if(c[pointerA] == c[pointerB]){
                pointerA++;
                pointerB--;
            }else{
                return false;
            }
        }
        return true;
    }
}

public class MainClass {
}
