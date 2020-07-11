package com.ibairah.Medium.lc670MaximumSwap;

import java.util.Arrays;

/**
 * Created by ibairah on 2020/7/10.
 *
 * Given a non-negative integer, you could swap two digits at most
 * once to get the maximum valued number. Return the maximum valued
 * number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
class Solution {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        //储存0-9每个数字最后出现的位置
        int[] bucket = new int[10];
        for(int i = 0; i < c.length; i++){
            bucket[ c[i] - '0' ]  = i;
        }

        for(int i = 0 ; i < c.length; i++){
            //判断数字的大小
            for(int j = 9; j > c[i] - '0' ; j--){
                //看是否出现过，并且在当前i的后面
                if(bucket[j] > i){
                    swap(c,bucket[j],i);
                    return Integer.valueOf(String.valueOf(c));
                }
            }
        }
        return num;
    }

    private void swap(char[] c,int i , int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumSwap(2736);
    }
}
