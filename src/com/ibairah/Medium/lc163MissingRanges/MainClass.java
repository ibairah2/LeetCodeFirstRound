package com.ibairah.Medium.lc163MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/16/20.
 * Given a sorted integer array nums, where the range of elements
 * are in the inclusive range [lower, upper], return its missing
 * ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long startLower = (long) lower;
        long endupper = (long)upper;
        for(int num: nums){
            if(num == startLower){
                startLower++;
            }else if(startLower < num) {
                if (startLower + 1 == num) {
                    res.add(String.valueOf(startLower));
                } else {
                    res.add(startLower + "->" + (num - 1));
                }
                startLower = (long) num + 1; //将当前的值变为 num+1
            }
        }

        if(startLower == endupper){
            res.add(String.valueOf(startLower));
        }else if(startLower < endupper){
            res.add(startLower + "->" + endupper);
        }
        return res;
    }
}

public class MainClass {
}
