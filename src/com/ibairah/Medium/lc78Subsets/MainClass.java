package com.ibairah.Medium.lc78Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ibairah on 6/9/20.
 * Given a set of distinct integers, nums, return all possible
 * subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0, new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        System.out.println("---------Divided Line-----------" );
        System.out.println("结果res :"+ res);
        if(idx == nums.length) {
            System.out.println("当前idx :"+ idx);
            res.add(new ArrayList<>(cur));
            return;
        }

        for( int i = idx; i<nums.length; i++){
            System.out.println("i的值 :"+ i);
            cur.add(nums[i]);
            System.out.println("当前curList :"+ cur);
            backtrack(nums,i+1, cur,res);  // 当i+1 = 3 时，break
            System.out.println("---------Finish One track-----------" );
            cur.remove(cur.size()-1);  // 减去最后一位
            System.out.println("Finish curList :"+ cur);
            System.out.println("-----------END-----------");
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(nums,0, new ArrayList<>(),res);
        return res;
    }

    private void backtrack2(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        System.out.println("---------Divided Line-----------" );
        System.out.println("结果res :"+ res);
        if(idx == nums.length) {
            System.out.println("当前idx :"+ idx);
            res.add(new ArrayList<>(cur));
        }else {
            // Not Chose
            backtrack2(nums, idx + 1, cur, res);

            // chose
            cur.add(nums[idx]);
            backtrack2(nums, idx + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}


public class MainClass {
    public static void main(String[] args) {
        int[] test = {1,2,3};
        Solution solution = new Solution();
        solution.subsets(test);
    }
}
