package com.ibairah.Easy.lc252MeetingRoom;

import java.util.Arrays;

/**
 * Created by ibairah on 6/19/20.
 *
 * Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person
 * could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please
 * reset to default code definition to get new method signature.
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        int[] startInterval = new int[intervals.length];
        int[] endInterval = new int[intervals.length];

        for(int i = 0; i<intervals.length; i++){
            startInterval[i] = intervals[i][0];  // 每个数组的第一位是他的开始
            endInterval[i] = intervals[i][1];
        }

        Arrays.sort(startInterval);
        Arrays.sort(endInterval);

        for(int i = 1; i< startInterval.length; i++){
            // 斜着对比，当第二个开始时间 比 第一个结束时间小的话 ，说明第一个还未结束
            // start : 0,  [5], 15
            // end   :[30], 10, 20
            if(startInterval[i] < endInterval[i-1] ) return false;
        }
        return true;
    }
}

public class MainClass {
}
