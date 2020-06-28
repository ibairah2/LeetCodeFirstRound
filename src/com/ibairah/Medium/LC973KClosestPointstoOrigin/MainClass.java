package com.ibairah.Medium.LC973KClosestPointstoOrigin;

import java.util.PriorityQueue;

/**
 * Created by ibairah on 6/26/20.
 *
 * We have a list of points on the plane.  Find the K closest
 * points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the
 * Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is
 * guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //1. corner case
        if( points == null || points.length == 0 || K < 1) return null;

        //!!!!!!!!!!!!!!!! Rebuild the compartor
        //2. 使用PriorityQueue -- 需要明白PQ的原理：！！！
        //当PQ放入二维数组的时候，比较的大小是他们斜边的大小，类似斜边的=sqrt（a^2+b^2)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));

        //3. traverse points and add to heap
        for(int[] point : points){
            minHeap.add(point);
        }
        //4. travse k times, 因为PQ已经排好序，所以依次加入结果
        int[][] res = new int[K][2]; // k个最短距离的点，每个点是2个数

        for(int i = 0; i < K; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}

public class MainClass {
}
