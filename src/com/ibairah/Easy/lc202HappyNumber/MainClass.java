package com.ibairah.Easy.lc202HappyNumber;

import java.util.HashSet;

/**
 * Created by ibairah on 6/24/20.
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the
 * sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while( n != 1){
            int newNumber = 0;
            while( n != 0){
                int temp = n % 10;
                newNumber += temp * temp;
                n /= 10;
            }

            if(!set.add(newNumber)){
                return false;
            }

            n = newNumber;
        }

        return true;
    }
}
public class MainClass {
}
