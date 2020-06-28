package com.ibairah.Medium.lc957PrisonCellsAfterNDays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ibairah on 6/25/20.
 *
 * There are 8 prison cells in a row, and each cell is either
 * occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes
 * according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or
 * both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last
 * cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following
 * way: cells[i] == 1 if the i-th cell is occupied, else cells[i]
 * == 0.
 *
 * Given the initial state of the prison, return the state of the
 * prison after N days (and N such changes described above.)
 *
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 *
 *
 * Note:
 *
 * cells.length == 8
 * cells[i] is in {0, 1}
 * 1 <= N <= 10^9
 */


//每14次是一个重复
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //1.corner case
        if(cells == null || cells.length == 0 || N < 0) return null;


        //a set to determine if find the cycle;
        HashSet<String> set = new HashSet<>();
        boolean cycle = false;
        int cycleCount = 0;

        // loop N days
        for(int i = 0; i < N; i++){
            int[] temp = nextDay(cells);
            String s = Arrays.toString(temp);
            //如果set中包含了当前和这一天一样的数组，说明找到了循环
            if(!set.contains(s)){
                set.add(s);
                cycleCount++;
            }else{
                cycle = true;
                break;
            }
            //如果还没有找到规律，更新新的一天
            cells = nextDay(cells);
        }

        if(cycle){
            // 缩小N通过找出N的余数
            N = N % cycleCount;
            for( int i = 0; i < N; i++){
                cells = nextDay(cells);
            }
        }

        return cells;
    }


    // a function return nextDay cells
    private int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];

        for( int i = 1; i < cells.length-1; i++){
            if(cells[i-1] == cells[i+1]){
                temp[i] = 1;
            }else{
                temp[i] = 0;
            }
        }

        return temp;
    }
}
public class MainClass {
}
