package com.ibairah.Medium.lc11ContainerWithMostWater;

/**
 * Created by ibairah on 5/28/20.
 * Given n non-negative integers a1, a2, ..., an , where each
 * represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of line i is at (i, ai) and
 * (i, 0). Find two lines, which together with x-axis forms a
 * container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,
 * 8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class MainClass {
    public static void main(String[] args){
        int[] test = {1,8,6,2,5,4,8,3,7};
        Solution sl = new Solution();
        sl.maxArea2(test);
    }
}

class Solution {
    // Two pointer
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int pointerA = 0;
        int pointerB = height.length-1; // 从后往前看

        // 双方不断靠近
        while(pointerA < pointerB){
            //选定高度, 左边矮于右边时
            if(height[pointerA] < height[pointerB]){
                maxArea = Math.max(maxArea,height[pointerA] * (pointerB-pointerA));
                pointerA +=1 ;
            }
            else{
                maxArea =Math.max(maxArea, height[pointerB] * (pointerB-pointerA)) ;
                pointerB -=1 ;
            }
        }
        return maxArea;
    }

    // brute force
    public int maxArea(int[] height) {
        int maxarea = 0;
        int temp_area = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                                // 矮一点的柱        *      i，j之间的距离
                temp_area = Math.min(height[i], height[j])  * (j - i);
                maxarea = Math.max(maxarea, temp_area);
        return maxarea;
    }


}