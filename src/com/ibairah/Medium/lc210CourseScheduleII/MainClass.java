package com.ibairah.Medium.lc210CourseScheduleII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ibairah on 6/17/20.
 *
 * There are a total of n courses you have to take, labeled from 0
 * to n-1.
 *
 * Some courses may have prerequisites, for example to take course
 * 0 you have to first take course 1, which is expressed as a pair:
 * [0,1]
 *
 * Given the total number of courses and a list of prerequisite
 * pairs, return the ordering of courses you should take to finish
 * all courses.
 *
 * There may be multiple correct orders, you just need to return
 * one of them. If it is impossible to finish all courses, return
 * an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take
 * course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take
 * course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be
 *              taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another
 *              correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of
 * edges, not adjacency matrices. Read more about how a graph is
 * represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 1. initialize
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;

        //2. fill indegree requirments
        for(int[] pair: prerequisites){
            indegree[pair[0]]++;
        }

        //3. fill queue with non-prerequisites courses
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                res[k++] = i;  // 添加无先修课程到res
            }
        }

        //4. BFS
        while(!queue.isEmpty()){
            int pre = queue.poll();
            for(int[] pair:prerequisites ){
                if(pair[1] == pre){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }

        return (k == numCourses) ? res : new int[0];
    }
}

public class MainClass {
}
