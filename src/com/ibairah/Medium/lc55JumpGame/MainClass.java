package com.ibairah.Medium.lc55JumpGame;

/**
 * Created by ibairah on 6/8/20.
 *
 * Given an array of non-negative integers, you are initially
 * positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at
 * that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the
 * last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach
 * the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 *
 */

class Solution {

    // 从后往前看的方法
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for( int i = nums.length-1; i >= 0; i--){
            System.out.println(" i :"+ i);
            System.out.println(" nums[i] :"+ nums[i]);
            System.out.println(" last :"+ last);
            if( i + nums[i] >= last){
                last = i;
                System.out.println(" in if last = " + last );
            }
            System.out.println("---------Divided Line-----------" );
        }
        return last == 0;
    }

    public boolean canJump2(int[] nums) {
        if(nums.length <2 ) return true;
        int farthest_reach = 0;
        // i <= farthest_reach指这个数必须是我们要能到达范围的数
        // 如果 i 比 最远距离大的话，说明已经走不下去了
        for(int i = 0; i < nums.length && i <= farthest_reach; i++){
            // i当前的数，加上nums[i]可能走的数
            farthest_reach = Math.max(nums[i]+i,farthest_reach);
            System.out.println("farthest_reach  :"+ farthest_reach);
            if(farthest_reach >= nums.length-1 ){
                System.out.println("  true " );
                return true;
            }
        }
        System.out.println(" false " );
        return false;
    }
}

public class MainClass {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        int[] nums2 = {2,3,1,1,4};
        Solution solution = new Solution();
        solution.canJump2(nums);
        System.out.println("---------Section 2-----------" );
        solution.canJump2(nums2);
    }
}
