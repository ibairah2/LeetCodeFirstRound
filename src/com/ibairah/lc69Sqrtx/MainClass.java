package com.ibairah.lc69Sqrtx;

/**
 * Created by ibairah on 6/2/20.
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed
 * to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are
 * truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */

// 找规律  1,4,9,16,25
//  相差：1 3 5 7 9
//  △ =    2 2,2,2,2
class Solution {
    // 二分法
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public int mySqrt(int x) {
        int cur = 0;
        int res = 0;
        int add = 1;

        while(cur <= x){
            if(Integer.MAX_VALUE - cur < add) return res;
            cur += add;
            res++;
            add+=2;
        }
        return res-1;
    }


}


public class MainClass {
}
