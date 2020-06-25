package com.ibairah.Easy.lc387FirstuniqueCharacter;

import java.util.HashMap;

/**
 * Created by ibairah on 6/23/20.
 * Given a string, find the first non-repeating character in it and
 * return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 *
 * Note: You may assume the string contain only lowercase English
 * letters.
 */

//题意： 找到底一个非重复的字母
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
public class MainClass {
}
