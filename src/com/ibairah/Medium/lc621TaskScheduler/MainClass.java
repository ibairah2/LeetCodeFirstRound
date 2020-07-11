package com.ibairah.Medium.lc621TaskScheduler;

import java.util.Arrays;

/**
 * Created by ibairah on 2020/7/10.
 *
 * You are given a char array representing tasks CPU need to do. It
 * contains capital letters A to Z where each letter represents a
 * different task. Tasks could be done without the original order
 * of the array. Each task is done in one unit of time. For each
 * unit of time, the CPU could complete either one task or just be
 * idle.
 *
 * However, there is a non-negative integer n that represents the
 * cooldown period between two same tasks (the same letter in the
 * array), that is that there must be at least n units of time
 * between any two same tasks.
 *
 * You need to return the least number of units of times that the
 * CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work
 * since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F",
 * "G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle
 * -> A -> idle -> idle -> A
 *
 *
 * Constraints:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */

//https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/

// [A,A,A,A,A,A] n = 2， 6个A至少需要16时间，  n = 3 -》 (6-1) * 4 + 1 = 21个时间
//                                           A-> i ->i ->i ->A
//先从最简单的情况看起，现在就算没有其他任务，我们完成任务A所需的时间应该是
// （6-1）*3+1=16，因为最后一个桶子，不存在等待时间

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for(char c : tasks){
            bucket[c - 'A']++;
        }
        Arrays.sort(bucket);

        //出现次数最多的次数
        int mostFreq = bucket[25];
        int last_idle = 0;
        for(int i = 25; i >= 0; i--){
            //最后一桶的任务数
            //如果B和A出现一样次数，则表示最后需要加一个idle
            if(bucket[i] == bucket[25]){
                last_idle++;
            }
        }

        //如果有很多不同字母，则表示不需要休息时间就可以完成；
        int num1 = tasks.length;
        //总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数
        int num2 = (mostFreq - 1) * (n + 1) + last_idle;

        return Math.max(num1,num2);
    }
}
public class MainClass {
}
