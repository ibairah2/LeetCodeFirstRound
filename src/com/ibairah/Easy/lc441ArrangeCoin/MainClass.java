package com.ibairah.Easy.lc441ArrangeCoin;

/**
 * Created by ibairah on 7/1/20.
 *
 * You have a total of n coins that you want to form in a staircase
 * shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can
 * be formed.
 *
 * n is a non-negative integer and fits within the range of a
 * 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */

// 用的最大的硬币数是  1+2+3+....+k <= n  ==> (1+k)*k/2 <=n
// （首项+末项）*项数/2
// 找到最大的k

// 方法二： 直接推数学公式
// class Solution {
//   public int arrangeCoins(int n) {
//     //k(k+1)≤2N  ==》 k^2+k-2N≤0 ==》  k = (-b+-(sqrt(4ac))) /2a
//     return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
//   }
// }

//方法一：Binary Search 找最大k
class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        //找到临界点k，返回k
        while(start + 1 < end){
            long target = start + (end - start)/2;
            System.out.println("Loop target :"+ target);
            // 用的最大的硬币数是  1+2+3+....+k <= n  ==> (1+k)*k/2 <=n
            //（首项+末项）*项数/2
            long sum = (target + 1) * target / 2;
            System.out.println("Loop sum :"+ sum);
            // 如果总数大于n， end左移
            if(sum > n) {
                end = target;
                System.out.println("Loop end :"+ end);
            }
            else {
                start = target;
                System.out.println("Loop start :"+ start);
            }

        }

        System.out.println("start :"+ start);
        System.out.println("end :"+ end);
        // check start sum新的总数，（首项+末项）*项数/2
        long sum = (1+start) * start / 2;
        System.out.println("Start sum :"+ sum);
        if( sum > n) return (int)start - 1;

        // check end sum, end sum小于n
        sum = (1+end) * end / 2;
        System.out.println("End sum :"+ sum);
        if( sum <= n) return (int)end;

        //到sum依然是sum大于n
        return (int)end - 1;
    }
}

public class MainClass {
}
