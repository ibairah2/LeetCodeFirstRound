package com.ibairah.Medium.lc986IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 2020/7/11.
 *
 * Given two lists of closed intervals, each list of intervals is
 * pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the
 * set of real numbers x with a <= x <= b.  The intersection of two
 * closed intervals is a set of real numbers that is either empty,
 * or can be represented as a closed interval.  For example, the
 * intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],
 * [15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *  
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 */

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res= new ArrayList<>();
        int pA = 0, pB = 0;
        while(pA < A.length && pB < B.length){
            int start = Math.max(A[pA][0],B[pB][0]);
            int end = Math.min(A[pA][1],B[pB][1]);
            //如果start小于end 说明 有交集，则加入res
            if(start <= end) res.add(new int[]{start,end});
            // 谁的右界更短，谁的指针+1
            if(A[pA][1] < B[pB][1]) pA++;
            else pB++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}


public class MainClass {
}
