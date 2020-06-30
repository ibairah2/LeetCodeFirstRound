package com.ibairah.Hard.lc43TrappingRainWater;

/**
 * Created by ibairah on 6/29/20.
 *
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water it is
 * able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,
 * 3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Solution {
    public int trap(int[] height) {
        int max = 0;
        //
        int leftMax = 0;
        int rightMax = 0;
        // start and end pointer
        int start = 0;
        int end = height.length - 1;

        while(start < end){
            leftMax = Math.max(leftMax,height[start]);
            rightMax = Math.max(rightMax,height[end]);
            if(leftMax <= rightMax){
                max += leftMax - height[start];
                start++;
            }else{
                max += rightMax - height[end];
                end--;
            }
        }

        return max;
    }
}

public class MainClass {
}
