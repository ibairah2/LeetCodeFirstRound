package com.ibairah.Medium.lc395LongestSubStringWithAtLeastKrepreating;

/**
 * Created by ibairah on 6/22/20.
 *
 * Find the length of the longest substring T of a given string
 * (consists of lowercase letters only) such that every character
 * in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and
 * 'b' is repeated 3 times.
 */
class Solution {
    public int longestSubstring(String s, int k) {
        //1.corner case
        if(s == null || s.length() ==0 ) return 0;

        //2.给每个letter字母创建一个位置，每出现一次+1
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            //比如每出现一次b，index 1的位置就会++，出现a，index 0的位置就会++
            hash[s.charAt(i) - 'a']++;
        }

        //3.判定是否是一个满足条件的string
        boolean fullstring = true;
        for( int i = 0; i < s.length(); i++){
            //如果有这个字母出现过，但是这个字母出现次数小于k次
            if(hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k){
                fullstring = false;
            }
        }
        if(fullstring == true) return s.length();

        //4. Two pointer + Recursive
        //通过两个指针加上递归
        int start = 0; int end = 0; int res = 0;
        while(end < s.length()){
            //如果当前字母出现次数小于k，则切割掉当前字母，并返回之前的长度
            if(hash[s.charAt(end) - 'a'] < k){
                //将之前的重复字母递归到fullstring中去，返回res的值
                res = Math.max(res,longestSubstring(s.substring(start,end),k));
                //将开头指针移到当前字母下一位
                start = end + 1;
            }
            end++;
        }
        //最后再判定最后一位是否还有满足当前情况的字母
        res = Math.max(res,longestSubstring(s.substring(start),k));
        return res;
    }
}
public class MainClass {
}
