package com.ibairah.Medium.lc90SubsetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 2020/7/12.
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        //!!!需要必须先排序
        Arrays.sort(nums);
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }

    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> temp,int index){
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            //i > index为了防止i = 0,
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(nums,res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {

//         List<List<Integer>> res = new ArrayList<>();
//         if (nums == null || nums.length == 0) return res;
//         Arrays.sort(nums);
//         backtrack(0, nums, res, new ArrayList<>());
//         return res;


//     }

//     public void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> tmp_list) {
//         res.add(new ArrayList<>(tmp_list));
//         for (int i = idx; i < nums.length; i++) {
//             if (i > idx && nums[i - 1] == nums[i]) continue;
//             tmp_list.add(nums[i]);
//             backtrack(i + 1, nums, res, tmp_list);
//             tmp_list.remove(tmp_list.size() - 1);
//         }
//     }
// }


public class MainClass {
}
