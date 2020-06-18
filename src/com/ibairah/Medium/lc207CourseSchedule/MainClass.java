package com.ibairah.Medium.lc207CourseSchedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ibairah on 6/17/20.
 * There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course
 * 0 you have to first take course 1, which is expressed as a pair:
 * [0,1]
 *
 * Given the total number of courses and a list of prerequisite
 * pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0.
 *              So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0,
 *              and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of
 * edges, not adjacency matrices. Read more about how a graph is
 * represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 1 <= numCourses <= 10^5
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; //创建nums个课程，比如0-7个课程
        int res = numCourses;

        for(int[] pair : prerequisites){

            // [1,0] => 0->1    // pair[0] -> 1;
            indegree[pair[0]]++; // indegree[1]++; --> 1需要的前置课程+1

            System.out.println("pair: "+ Arrays.toString(pair));
            System.out.println("indegree: "+ Arrays.toString(indegree));

        }

        Queue<Integer> queue = new LinkedList<>();

        // 把不需要前置课程的课放入queue中
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        //BFS
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int[] pair : prerequisites){
                if(indegree[pair[0]] == 0){
                    continue;
                }

                if(pair[1] == curr){
                    indegree[pair[0]] --;
                }

                if(indegree[pair[0]] == 0){
                    queue.offer(pair[0]);
                }
            }
        }

        // recheck if possible
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] != 0){
                return false;
            }
        }

        return true;
    }
}

public class MainClass {
}
