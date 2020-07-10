package com.ibairah.Medium.lc264UglyNumberII;

import java.util.*;

/**
 * Created by ibairah on 7/4/20.
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only
 * include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of
 * the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 1; i < Integer.MAX_VALUE; i *= 2){
            for(int j = i; j < Integer.MAX_VALUE; j*=3){
                for(int k = j; k < Integer.MAX_VALUE; k*=5){
                    res.add(k);
                }
            }
        }

        Collections.sort(res);

        System.out.println("res.get(n)  :"+ res.get(n));
        return res.get(n);
    }
}

public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nthUglyNumber(10);
    }
}
