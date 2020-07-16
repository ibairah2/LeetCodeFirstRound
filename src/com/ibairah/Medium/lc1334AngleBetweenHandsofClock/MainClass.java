package com.ibairah.Medium.lc1334AngleBetweenHandsofClock;

/**
 * Created by ibairah on 2020/7/15.
 * Given two numbers, hour and minutes. Return the smaller angle
 * (in degrees) formed between the hour and the minute hand.
 *
 *
 *
 * Example 1:
 *
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 *
 *
 *
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 *
 *
 *
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * Example 4:
 *
 * Input: hour = 4, minutes = 50
 * Output: 155
 * Example 5:
 *
 * Input: hour = 12, minutes = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * Answers within 10^-5 of the actual value will be accepted as
 * correct.
 */

class Solution {
    public double angleClock(int hour, int minutes) {
        // hour每小时度数为 360 / 12hour = 30度；
        // 但是分针走的时候，时针也会走一点点，所以必须的加上分针对对于时针的贡献
        // 比如：30分钟 / 60 = 0.5 hour， 所以时针再加上0.5hour
        double hourHand = (hour + minutes / 60.0 ) * 30;

        //分针走的度数 360 / 60mins = 6度
        double minHand = minutes * 6;

        double dis = Math.abs(hourHand - minHand);

        return Math.min(dis,360 - dis);
    }
}

public class MainClass {
}
