package com.ibairah.Medium.lc253MeetingRoomsII;

import java.util.Arrays;

/**
 * Created by ibairah on 6/19/20.
 *
 * Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum
 * number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please
 * reset to default code definition to get new method signature.
 *
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0 ; i<intervals.length; i++ ){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int endPoint = 0;


        //
        for( int i = 0; i< start.length; i++){
            // 如果当前start<end说明有一个在用，如果下一个开始时间比当前结束时间要早要小，则结果+1；
            // 在下一个新的会议进入，如果新的会议>当前结束时间，说明结束时间需要往下一位移动
            // start : 0,  [5], 15,
            // end   :[30], 10, 20,
            if(start[i] < end[endPoint]){
                res++;
            }else{
                endPoint++;
            }
        }
        return res;
    }
}


public class MainClass {
}
