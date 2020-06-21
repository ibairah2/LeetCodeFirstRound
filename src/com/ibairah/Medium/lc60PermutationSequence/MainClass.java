package com.ibairah.Medium.lc60PermutationSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 6/20/20.
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get
 * the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */

//https://www.youtube.com/watch?v=xdvPD1IiyUM


class Solution {
    public String getPermutation(int n, int k) {
        // 例子： n = 3， k = 4

        // 1. 将所有数字添加进入nums =》nums = { 1，2，3 }
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        // 2.找出每一个的阶乘为多少，意义是知道当前数字有多少种组合
        // 当还剩 2，3时候   =》 23 ，32 还剩两种组合
        // 每一组对应的有多少个数字
        int[] fact = new int[n];
        fact[0] = 1;
        for( int i = 1; i < n; i++){
            fact[i] = fact[i-1] * i;
        }
        //System.out.println("fact "+ Arrays.toString(fact));

        // 3. transfer to k to indices;
        k = k - 1;


        // 4.从最高位一位一位来确定数字
        // k/f[i] 找出当前在哪一组
        // num加入到res的空位中，同时删除当前num的数
        // k%f[i] 通过取余来更新k，同时也是选中当前组的哪一位置商
        // n-1-i 作为fact的index =》 fact[2] = 2;

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++ ){
            int num = nums.remove(k/fact[n-1-i]);
            //System.out.println(num);
            res.append(num);
            k %= fact[n-1-i];
        }

        return res.toString();
    }
}

public class MainClass {
}
