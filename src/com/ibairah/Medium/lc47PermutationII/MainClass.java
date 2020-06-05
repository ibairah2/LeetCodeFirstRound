package com.ibairah.Medium.lc47PermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 6/4/20.
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort first
        backtrack(res, new boolean[nums.length], new ArrayList<>(),nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, boolean[] used, List<Integer> tempList, int[] nums) {
        // exist
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }else {
            //提前设置，不然用i-1会outIndex
            int pre = nums[0] - 1;
            //break down
            for (int i = 0; i < nums.length; i++) {
                // 设为false，表明没出现过
                if (used[i] == false && nums[i] != pre ) {
                    pre = nums[i];  // update pre
                    tempList.add(nums[i]);
                    used[i] = true;
                    backtrack(res, used, tempList, nums);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}

public class MainClass {
}


