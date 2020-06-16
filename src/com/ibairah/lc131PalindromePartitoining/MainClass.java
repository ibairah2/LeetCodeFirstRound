package com.ibairah.lc131PalindromePartitoining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/15/20.
 * Given a string s, partition s such that every substring of the
 * partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList(),s, 0); // 0--> start point;
        return res;
    }


    // dfs helper function
    public void helper(List<List<String>> res, List<String> temp, String s, int start){
        //1. exit;
        if(start == s.length()){
            res.add(new ArrayList(temp));
            return;
        }

        //2.
        for( int i = start + 1; i <= s.length(); i++){
            //比如aab，0-1 ，判断a是否为pd
            if(isValid(s.substring(start,i))){
                temp.add(s.substring(start,i));
                helper(res,temp,s,i);  //
                temp.remove(temp.size()-1);
            }
        }
    }


    // check if is palindrome
    public boolean isValid(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}
public class MainClass {
}
