package com.ibairah.lc28ImplementstrStr;

/**
 * Created by ibairah on 6/1/20.
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a
 * great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is
 * an empty string. This is consistent to C's strstr() and Java's
 * indexOf().
 */

class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack == null || haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;
        int slow = 0;
        System.out.println(" length :"+ (haystack.length()-needle.length()));
        for (int fast = 0; fast < needle.length(); fast++) {
            System.out.println(" fast in loop: "+ fast);
            for(slow = 0; slow<needle.length();slow++){
                System.out.println(" slow: "+ slow);
                if(haystack.charAt(fast+slow) != needle.charAt(slow)){
                    break;
                }
            }
            if(slow == needle.length()){
                System.out.println(" fast :"+ fast);
                return fast;
            }
        }
        System.out.println("-1");
        return -1;
    }
}

// 双指针
class Solution2 {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
public class MainClass {
    public static void main(String[] args) {
        String haystack = "a", needle = "a";
        String t1 ="mississippi", t2 = "issip";
        Solution solution = new Solution();
       // solution.strStr(haystack,needle);
        solution.strStr(t1,t2);
    }
}
