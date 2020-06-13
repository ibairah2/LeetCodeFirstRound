package com.ibairah.lc172FactorialTraillingZeroes;

import java.util.Arrays;

/**
 * Created by ibairah on 6/12/20.
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */


// 此题关键在于处理overflow，当input等于11时已经overflow
//初步看到这道题，我首先是懵逼的，阶乘结果有多少个0？what??!
//硬来肯定是不行的，仔细一想，会出现零只有一种情况嘛：2*5=10；
//所以我们可以将阶乘进行因式分解，比如5！=1*2*3*4*5=1*2*3*2*2*5,
// 共有1对2*5，所以结果就只有一个0嘛；有几对2*5,结果就有几个0！
//所以问题就简化为找有几对2*5,能不能进一步简化捏？必须可以啊!
//我们发现2的个数是远远多于5的，所以最终简化为了找出5的个数！
//如果找出5的个数呢，比如20!，从1到20,共有5，10，15,20,共有4个5，
// 即结尾0的个数为n/5！
//这样就ok么？当然没ok，25!结果不只是25/5=5个0，25结果有6个0,因为25=5*5，
// 有两个5。所以结果f(n)
// =n/5+f(n/5)!
//
//以下提供递归和非递归两种解法：

class Solution {
    // recursive
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        if (n < 10) return 1;
        return trailingZeroes(n / 5 + trailingZeroes(n / 5));
    }

    public int trailingZeroes2(int n) {
        int res = 0;
        // 50;
        while (n > 0) {
            System.out.println(" res :" + res);
            System.out.println(" n :" + n);
            res = res + n / 5; //先检查有多少个5
            n = n / 5;         //比如25中多一个额外的5
        }
        System.out.println("  " );
        System.out.println("res final  :"+ res );
        return res;
    }
}
public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trailingZeroes2(25);
    }

}
