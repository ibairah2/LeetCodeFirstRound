package com.ibairah.Medium.lc406QueueReconstructionbyHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 6/6/20.
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h
 * is the height of the person and k is the number of people in
 * front of this person who have a height greater than or equal to
 * h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

// 做法和思路，先把最高身高按他们要求顺序排入，
// 再插入比他们矮的人，因为高身高的人看不见前面矮的人

// T: O(n^2)  for(int[] p: people){
//            // insert particular person at the key value
//            // p[0]代表身高   p[1]代表value-k
//            // 把每个人加到下标为k的地方去
//            res.add(p[1],p);
//        }
// S: O(n)  List<int[]> res = new ArrayList<>();

class Solution {

    public int[][] reconstructQueue(int[][] people) {

        // lambda 表达式  -- Java！！！

        // a,b 可以代表两个人
        // a[0] 代表他的高-height
        // a[1] 代表他的value
        //  a[0] == b[0] 问他们的高是否相等
        // a[1] - b[1] sort他们通过升序排序
        // b[0] - a[0] sort降序排序
        Arrays.sort(people,(a,b) -> a[0] == b[0] ?
                a[1] - b[1] : b[0] - a[0]);


        Arrays.sort(people,(a,b) -> a[0] == b[0] ?
                Integer.compare(a[1],b[1]) :  //身高相等，按K值升序排序 0，1，2
                Integer.compare(b[0],a[0])); //身高不等，按身高降序排序 7，6，5


        List<int[]> res = new ArrayList<>();

        // iterate over these people array
        for(int[] p: people){
            // insert particular person at the key value
            // p[0]代表身高   p[1]代表value-k
            // 把每个人加到下标为k的地方去
            res.add(p[1],p);
        }
//        int n = people.length;
//        return res.toArray(new int[n][2]);

        //转化为二维数组类型
        int[][] ret = new int[people.length][2];
        for (int i = 0; i < res.size(); i++) {
            // 给每一个return赋值；
            ret[i] = res.get(i);
        }
        return ret;
    }
}
public class MainClass {
}
