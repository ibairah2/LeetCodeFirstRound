package com.ibairah.Medium.lc1167MinimumCosttoConnectSticks;

import java.util.PriorityQueue;

/**
 * Created by ibairah on 6/27/20.
 */

// 每merge一次都会产生一个cost，结果等于cost的总和
// 2，4，3
// 不同方法有不同结果
// cost = (2,4) 6 => 6 + (6+3)9 =>15
// cost = (2,3) 5 => 5 + (5+4)9 =>14


// 使用TreeHeap 和 priorityQueue能够每次添加回去后自动排序
// 每merge一次都会产生一个cost，结果等于cost的总和
// 2，4，3
// 不同方法有不同结果
// cost = (2,4) 6 => 6 + (6+3)9 =>15
// cost = (2,3) 5 => 5 + (5+4)9 =>14


// 使用TreeHeap 和 priorityQueue能够每次添加回去后自动排序
class Solution {
    public int connectSticks(int[] sticks) {
        //1.corner case
        if(sticks == null || sticks.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //2. add all number into pq
        for(int stick: sticks){
            pq.add(stick);
        }

        //3.poll out two number each time and add the result to pq;
        int res = 0;
        while(pq.size() > 1){
            int temp = pq.poll()+ pq.poll();
            pq.add(temp);
            res += temp;
        }

        return res;

    }
}
public class MainClass {
}
