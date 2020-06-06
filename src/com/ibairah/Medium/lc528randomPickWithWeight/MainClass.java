package com.ibairah.Medium.lc528randomPickWithWeight;

import java.util.Random;

/**
 * Created by ibairah on 6/5/20.
 *
 * Given an array w of positive integers, where w[i] describes the
 * weight of index i, write a function pickIndex which randomly
 * picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex",
 * "pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their
 * arguments. Solution's constructor has one argument, the array w.
 * pickIndex has no arguments. Arguments are always wrapped with a
 * list, even if there aren't any.
 */


// 题目意思， 解释：[0,1,2,3,4,5,6]
//                [1,5,10,20,10,5,5] = 56
//   取到0的概率 1/56,取到1的概率5/56，取到2的概率 10/56



//Use accumulated freq array to get idx.
//w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
//then get random val random.nextInt(14)+1, idx is in range [1,14]
//
//idx in [1,2] return 0
//idx in [3,7] return 1
//idx in [8,10] return 2
//idx in [11,14] return 3
//then become LeetCode 35. Search Insert Position
//35. Search Insert Position

class Solution {
    Random random;
    int[] wSum;
    public Solution(int[] w) {
        for(int i = 1; i< w.length;i++){
            w[i] = w[i] + w[i-1];
        }
        wSum = w;
    }

    public int pickIndex() {
        int len = wSum.length;
        //？？？？？？？？
        // int[] a=new int[rand.nextint(20)+1];
        // 中的20和1是什么意思为什么产生的整数范围是[0，20）？
        //Java nextInt()函数 nextInt( int num)
        // 能接受一bai个整数作为它所产du生的随机整数的上限,下限为零，
        // zhi比如： nextInt(4)将产生0,1,
        // 2,3这dao4个数字中的任何一个数字，注意这里不是0-4，而是0-3。
        // 。但下限总是零，不能更改，所以若要达到非零下限的效果，必须把
        // 上限减去下限的结果传给 nextInt( )
        // ，然后把下限加入 nextInt( ) 返回的整数。
        random = new Random(); // 为什么要在这提前申明random，不然下面random用不了
        int target = random.nextInt(wSum[len-1]) + 1;////????????? !!!

        int start = 0, end = len-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(wSum[mid] == target) return mid;

            else if ( target < wSum[mid] ) end = mid;
            else {
                start = mid;
            }
        }
        if(wSum[start] >= target) return start;
        else if ( wSum[end] < target) return end+1;
        else return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
public class MainClass {

}
