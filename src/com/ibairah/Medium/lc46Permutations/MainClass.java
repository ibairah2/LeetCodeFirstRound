package com.ibairah.Medium.lc46Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/4/20.
 * Given a collection of distinct integers, return all possible
 * permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */


//https://www.youtube.com/watch?v=4sROSJN_I6E
//https://www.youtube.com/watch?v=43w8tXWKSLw
//排列 permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums); //深度copy
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length ){
            res.add(new ArrayList<>(tempList));
            //why is it necessary to create a new ArrayList? Why
            // can't you just do list.add(tempList)?

            //1.
            //tempList is a list that is used throughout all the
            // recursive calls to keep track of the current recursion
            // path. When we finally reach the base case, we cannot
            // add this same list to the list of lists. This is
            // because when you add tempList, you are adding a
            // reference to tempList. This means that other recursive
            // paths can modify the path you just inserted into
            //the final list of lists.

            //2.
            //If you directly add tempList, Java will add a
            // reference to it, which will get meddled with as the
            // recursion goes on, hurting what was originally put
            // in 'list'. Hence it makes a copy of tempList to
            // preserve its state.Someone put it well on SO about
            // java's method of passing - "Imagine a balloon.
            // Calling a fn is like tying a second string to the
            // balloon and handing that second line to the fn."
            return;
        }
        for(int i = 0; i< nums.length;i++){
            if(tempList.contains(nums[i])) continue;
            else{
                tempList.add(nums[i]);
                backtrack(res,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }

}

public class MainClass {

}
