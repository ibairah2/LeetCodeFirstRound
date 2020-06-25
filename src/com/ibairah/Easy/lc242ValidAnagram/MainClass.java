package com.ibairah.Easy.lc242ValidAnagram;

import java.util.HashMap;

/**
 * Created by ibairah on 6/23/20.
 * Given two strings s and t , write a function to determine if t
 * is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you
 * adapt your solution to such case?
 */

// 题意： s和t有着完全相同次数的字母，顺序可以不一样

// Follow up ,用hashmap 处理unicode
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //!!map已经包含了s中的所有字母和出现次数，现在对应t中的字母
        for(char c2: t.toCharArray()){
            //如果map中没有当前字母
            if(map.get(c2) == null){
                return false;
            }else{
                //出现则 -1
                map.put(c2,map.get(c2)-1);
            }
        }

        for(char c: map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}
// 最优解法
// class Solution{
//     public boolean isAnagram(String s, String t) {
//       if(s.length() != t.length()) return false;

//       //类似bucket
//       int[] charCount = new int[26];
//       for(int i = 0; i < s.length(); i++){
//         charCount[s.charAt(i) - 'a']++;  // 当前这个字母出现次数++
//         charCount[t.charAt(i) - 'a']--;  // 当前这个字母出现次数--
//       }

//       for(int count: charCount){
//         if(count != 0){
//           return false;
//         }
//       }
//       return true;
//     }
// }

public class MainClass {
}
