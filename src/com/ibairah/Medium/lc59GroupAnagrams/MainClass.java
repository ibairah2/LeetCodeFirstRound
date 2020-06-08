package com.ibairah.Medium.lc59GroupAnagrams;

import java.util.*;

/**
 * Created by ibairah on 6/7/20.
 *  Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

//anagrams -字谜

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1.corner case
        if(strs.length == 0) return new ArrayList<>();

        // 2.create hashMap
        HashMap<String,List<String>> map= new HashMap<>();

        // 3.deal the problem
        for( int i = 0; i<strs.length; i++){
            //split strs to char and sort
            char[] c  = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        ////!!!!!!!!关键
        //返回 hashmap中所有的配对value值
        return new ArrayList<>(map.values());
    }
}
public class MainClass {
}
