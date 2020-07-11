package com.ibairah.Medium.lc636ExclusiveTimeofFunctions;

import java.util.List;
import java.util.Stack;

/**
 * Created by ibairah on 2020/7/10.
 * On a single threaded CPU, we execute some functions.  Each
 * function has a unique id between 0 and N-1.
 *
 * We store logs in timestamp order that describe when a function
 * is entered or exited.
 *
 * Each log is a string with this format: "{function_id}:{"start" |
 * "end"}:{timestamp}".  For example, "0:start:3" means the
 * function with id 0 started at the beginning of timestamp 3.
 * "1:end:2" means the function with id 1 ended at the end of
 * timestamp 2.
 *
 * A function's exclusive time is the number of units of time spent
 * in this function.  Note that this does not include any recursive
 * calls to child functions.
 *
 * The CPU is single threaded which means that only one function is
 * being executed at a given time unit.
 *
 * Return the exclusive time of each function, sorted by their
 * function id.
 *
 * Example 1:
 *
 *     -------
 * ---        --
 * 0 1 2 3 4 5 6
 *
 * Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 *
 * 程序0在0时刻调用，然后2时刻又递归调用了程序0，递归调用5时刻结束，
 * 然后程序1时刻7调用，时刻7结束，最后程序0时刻8结束
 *
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2
 * units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4
 * units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also
 * ends at the end of time 6, thus executing for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing,
 * and function 1 spends 4 units of total time executing.
 *
 *
 * Note:
 *
 * 1 <= n <= 100
 * Two functions won't start or end at the same time.
 * Functions will always log when they exit.
 *
 *
 */

class Solution {
    class Task{
        int id = 0;
        int time = 0;
        boolean isStart = true;

        Task(String[] split){
            this.id = Integer.parseInt(split[0]);
            this.time = Integer.parseInt(split[2]);
            this.isStart = split[1].equals("start");
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Task> stack = new Stack<>();

        int[] res = new int[n];
        for(String log : logs){
            Task task = new Task(log.split("\\:"));
            if(task.isStart){
                stack.push(task);
            }else{
                Task last = stack.pop();
                int duration = task.time - last.time + 1;
                res[task.id] += duration;
                // 栈若不空，说明之前还有任务没有执行完成，那个任务的执行时间需要减去当前任务的执行时间
                if(!stack.isEmpty()){
                    res[stack.peek().id] -= duration;
                }
            }
        }
        return res;
    }
}
public class MainClass {
}
