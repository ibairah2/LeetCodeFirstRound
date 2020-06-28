package com.ibairah.Easy.lc189RotateArray;

/**
 * Created by ibairah on 6/25/20.
 *
 * Given an array, rotate the array to the right by k steps, where
 * k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least
 * 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * It's guaranteed that nums[i] fits in a 32 bit-signed integer.
 * k >= 0
 */

//方法2: n & （n-1）
class Solution{
    public int hammingWeight(int n){
        int res = 0;
        while( n != 0){
            res++;
            //!!!技巧，记住
            //如果消去二进制表达的最后一位1
            n &= (n-1); // 快速消除1
        }
        return res;
    }
}


// 方法1: 基础，从左往右遍历
// public class Solution {
//     // you need to treat n as an unsigned value
//     public int hammingWeight(int n) {
//       int res = 0;
//       for(int i = 0; i < 32; i++){
//         res += n & 1;
//         n >>= 1; //
//       }
//       return res;
//     }
// }

public class MainClass {
}
