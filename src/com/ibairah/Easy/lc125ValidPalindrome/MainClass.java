package com.ibairah.Easy.lc125ValidPalindrome;

/**
 * Created by ibairah on 6/11/20.
 */

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                sb.append(c);
            }
        }

        String res = sb.toString().toLowerCase();

        int pointerA = 0;
        int pointerB = res.length()-1;

        while( pointerA <= pointerB){
            if(res.charAt(pointerA) != res.charAt(pointerB)){
                return false;
            }
            pointerA++;
            pointerB--;
        }

        return true;
    }
}

public class MainClass {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2= "race a car";
        String s3= "0P";
        Solution solution = new Solution();
        solution.isPalindrome(s3);

    }
}
