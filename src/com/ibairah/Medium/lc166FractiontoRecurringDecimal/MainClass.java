package com.ibairah.Medium.lc166FractiontoRecurringDecimal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ibairah on 6/16/20.
 * Given two integers representing the numerator and denominator of
 * a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part
 * in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        String sign = (numerator > 0) ^(denominator > 0) ? "-":"";
        res.append(sign);

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(num / den);

        num %= den;

        if(num == 0){
            return res.toString();
        }


        res.append(".");

        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        map.put(num,res.length());

        while(num!=0){
            num *= 10;
            res.append(num / den);
            num %= den;

            if(map.containsKey(num)){
                int index = map.get(num);
                res.insert(index,"(");
                res.append(")");
                break;
            }else{
                map.put(num,res.length());
            }

        }
        return res.toString();
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int ret=0;
        for (int num: nums) {
            if (!myMap.containsKey(num))  myMap.put(num, 1);
            else myMap.put(num, myMap.get(num)+1);
            if (myMap.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }
}



public class MainClass {

}
