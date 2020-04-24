package com.ibairah.lc136SingleNumber;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement
 it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
/**
 * Created by ibairah on 4/22/20.
 */
public class main {
    public static void main(String[] args) {
        int[] test = {4,1,2,1,2};
        Solution sl = new Solution();
        sl.singleNumber(test);
        System.out.println(" sl.singleNumber(test): "+ sl.singleNumber(test));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        /*
        Concept:
        If we take XOR of zero and some bit, it will return that bit
        a \oplus 0 = aa⊕0=a
        If we take XOR of two same bits, it will return 0
        a \oplus a = 0a⊕a=0
        a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
        So we can XOR all bits together to find the unique number.
         */

        //1^1^ 2^2^ 3^3^4
        // XOR 方法 将所有数放在一起，通过交换律，找出唯一一个单数
        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }
}
