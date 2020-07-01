package com.ibairah.Medium.lc438FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ibairah on 6/30/20.
 *
 * Given a string s and a non-empty string p, find all the start
 * indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the
 * length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram
 * of "abc".
 * The substring with start index = 6 is "bac", which is an anagram
 * of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram
 * of "ab".
 * The substring with start index = 1 is "ba", which is an anagram
 * of "ab".
 * The substring with start index = 2 is "ab", which is an anagram
 * of "ab".
 */

// SlidingWindow模版
/*
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        //must be the map size, NOT the string size because the char may be duplicate.
        //比如出现 t = "aa", map.size() = 1
        int counter = map.size();

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        //loop at the begining of the source string
        while(end < s.length()){

            char c = s.charAt(end);//get a character

            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;

            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition ){

                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }

                // save / update(min/max) the result if find a target
                // result collections or result int value

                begin++;
            }
        }
        return result;
    }
}
*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //corner case
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0) return res;
        if(s.length() < p.length()) return res;

        // create hashmap to store p
        Map<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        // sliding window for string s
        int start = 0;
        int end = 0;
        //等于map size而不是p.lenght，为了避免重复，p = "aa", p.length() = 2, map.size = 1
        int counter = map.size();
        while(end < s.length()) {
            // 取出快指针当前指向的字母
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                //[c,1] -> [c,0]
                map.put(c, map.get(c) - 1);
                //如果当前字母满足,总要求counter--；
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            //counter == 0，说明我找其中一个p是anagram，
            while (counter == 0) {
                //如果失败，复原消除掉的字符
                char tempc = s.charAt(start);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                //判断是否完成
                if (end - start == p.length()) {
                    res.add(start);
                }
                start++;
            }
        }
        //return res;
        return res;
    }
}

public class MainClass {
}
