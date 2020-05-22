package com.ibairah.Medium.lc3LongestSubstring;

import java.util.HashSet;

/**
 * Created by ibairah on 5/21/20.
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class main {
    public static void main(String[] args) {
        String s = "pwwkew";
        Solution sl = new Solution();
        sl.lengthOfLongestSubstring(s);
    }
}

 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> hash_set = new HashSet<>();

        while (b_pointer < s.length()){
            if(!hash_set.contains(s.charAt(b_pointer))){ //check if it's a new char
                hash_set.add(s.charAt(b_pointer)); // add new char to hashset
                b_pointer++;    // b  move on

                //!!!!!!!!!!!!!!!!!!关键步骤-需要理解
                max = Math.max(hash_set.size(),max);// hashset is current size with new char
            }
            else{
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        System.out.println(" max :"+ max);
        return max;
    }
}
