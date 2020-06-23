package com.ibairah.Medium.lc454FourSumII;

import java.util.HashMap;

/**
 * Created by ibairah on 6/22/20.
 *
 * Given four lists A, B, C, D of integer values, compute how many
 * tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] +
 * D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of
 * N where 0 ≤ N ≤ 500. All integers are in the range of -228 to
 * 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) +
 * 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) +
 * 0 = 0
 */


//Take the arrays A and B, and compute all the possible sums of two
// elements. Put the sum in the Hash map, and increase the hash map
// value if more than 1 pair sums to the same value.
//
//Compute all the possible sums of the arrays C and D. If the hash
// map contains the opposite value of the current sum, increase the
// count of four elements sum to 0 by the counter in the map.
//
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //列出所有A+B的可能性
        for(int a : A){
            for(int b : B){
                map.put(a+b, map.getOrDefault(a+b,0)+1);
            }
        }
        // 找出对应的可能性
        int res = 0;
        for(int c : C){
            for(int d : D){
                //如果找到这个key，就找到个key的对应的次数，若如果没有就是0；
                res += map.getOrDefault(-1*(c+d),0);
            }
        }
        return res;
    }
}
public class MainClass {
}
