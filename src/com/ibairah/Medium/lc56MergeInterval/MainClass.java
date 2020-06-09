package com.ibairah.Medium.lc56MergeInterval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ibairah on 6/8/20.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
       int length = intervals.length; // 几个区间

       if( length <= 1) return intervals;

       int[] start = new int[length];
       int[] end = new int[length];

       for( int i = 0 ; i< length; i++){
           start[i] = intervals[i][0]; //每个区间的第一位
           end[i] = intervals[i][1]; // 每个区间的第二位
       }
       Arrays.sort(start);
       Arrays.sort(end);

       int startIdx = 0;
       int endIdx = 0;

       List<int[]> result = new LinkedList<>();

       while(endIdx < length){
           if(endIdx == length -1|| start[endIdx+1] > end[endIdx]){
               result.add(new int[]{start[startIdx],end[endIdx]});
               startIdx = endIdx + 1;
           }
           endIdx++;
       }
       return result.toArray(new int[result.size()][]);
    }
}



public class MainClass {
}
