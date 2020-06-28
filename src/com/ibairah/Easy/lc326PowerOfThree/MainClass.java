package com.ibairah.Easy.lc326PowerOfThree;

/**
 * Created by ibairah on 6/25/20.
 *
 * Given an integer, write a function to determine if it is a power
 * of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */

// Follow up
// 方法2思路： 如果这个数是3的power，那么他一定能被3的最大值的除尽
class Solution {
    public boolean isPowerOfThree(int n) {
        //1. corner case
        if( n <= 0 ) return false;

        // 2.通过这个去查找3的最大power， i = 19 时候， 所以 3^19 = 1162261467
        // int j = 1;
        // for(int i = 0; i <= 25; j *=3 ,i++){
        //   System.out.println("i: "+ i + "+j: "+ j);
        // }

        // 3.用最大值除n应该没有余数;
        return 1162261467 % n == 0;
    }
}

// 方法1： 直接运算
// class Solution {
//     public boolean isPowerOfThree(int n) {
//       if(n <= 0) return false;

//       while( n % 3 == 0){
//         n = n / 3;
//       }

//       return n == 1;
//     }
// }
public class MainClass {
}
