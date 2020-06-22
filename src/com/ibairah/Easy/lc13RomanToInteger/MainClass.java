package com.ibairah.Easy.lc13RomanToInteger;

import java.util.HashMap;

/**
 * Created by ibairah on 5/30/20.
 * Roman numerals are represented by seven different symbols: I, V,
 * X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two
 * one's added together. Twelve is written as, XII, which is simply
 * X + II. The number twenty seven is written as XXVII, which is XX
 * + V + II.
 *
 * Roman numerals are usually written largest to smallest from left
 * to right. However, the numeral for four is not IIII. Instead,
 * the number four is written as IV. Because the one is before the
 * five we subtract it making four. The same principle applies to
 * the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is
 * guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */


// IV = 4   等于 ab pattern   a比b小
    //解法： 加上所有值，再重新搜索如果遇见ab pattern， 减去2a
// VI = 6   5+1 ；

class Solution {
    public int romanToInt(String s) {
        // 将所有值放入map
        HashMap<Character, Integer> values= new HashMap<Character, Integer>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        char pre = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += values.get(s.charAt(i)); // 先加上所有的值
            //如果pre存在， 同时是ab  pattern， a < b
            if(pre != 0 && (values.get(s.charAt(i))> values.get(pre))){
                System.out.println("in if  :" );
                res -= values.get(pre) * 2;
            }
            pre = s.charAt(i);
        }
        System.out.println(" res :"+ res);
        return res;
    }


    // 最简办法枚举 出现ab pattern, 结果减去ab值，其他则相加
    public int romanToInt2(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char[] c=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;

        }

        return sum;

    }
}

class Solution13{
    public int romanToInt(String s) {
        HashMap<Character,Integer> values = new HashMap<Character,Integer>();
        values.put('I',1);
        values.put('V',5);
        values.put('X',10);
        values.put('L',50);
        values.put('C',100);
        values.put('D',500);
        values.put('M',1000);

        char pre = 0;
        int res = 0;

        for(int i = 0; i< s.length();i++){
            res += values.get(s.charAt(i));
            if(pre != 0 && values.get(s.charAt(i)) > values.get(pre)){
                res -= values.get(pre) * 2;
            }
            pre = s.charAt(i);
        }

        return res;
    }
}

public class MainClass {
    public static void main(String[] args) {
        String s = "III";
        String s2 = "IV";
        Solution solution = new Solution();
        // solution.romanToInt(s);
        solution.romanToInt(s2);
    }
}

