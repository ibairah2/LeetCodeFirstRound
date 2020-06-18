package com.ibairah.Medium.lc179LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ibairah on 6/17/20.
 *
 * Given a list of non negative integers, arrange them such that
 * they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a
 * string instead of an integer.
 */

// 调用sort用的就是comparator
// 此题考察复写compartor
class Solution {
    public String largestNumber(int[] nums) {
        // 1. corner case
        if(nums.length == 0 || nums == null) return "";

        //2. transfer int to string, and add to String Array
        String[] st_num = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            st_num[i] = String.valueOf(nums[i]);
        }

        //3.rewrite comparator;
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);   //！！因为此题需要比较大的在前，所以s2.compare(s1);
            }
        };

        Arrays.sort(st_num,comp); //sort string Array， 通过调用新的sort方法；


        // 4.recheck the first element is not 0
        if(st_num[0].equals("0")) return "0";

        // 5.combine to final string;
        StringBuilder sb = new StringBuilder();
        for(String s: st_num){
            sb.append(s);
        }

        return sb.toString();
    }
}
public class MainClass {
}
