package com.ibairah.Hard.lc315CountofSmallerNumbersAfterSelf;


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ibairah on 2020/7/14.
 * You are given an integer array nums and you have to return a new
 * counts array. The counts array has the property where counts[i]
 * is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 */


class TreeNode{
    int val;
    int leftCount;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
        leftCount = 0; //小于他的左边的个数
    }
}


class Solution{
    private TreeNode insert(TreeNode root, TreeNode curNode,int[] res, int i){
        // exit
        if(root == null){
            root = curNode;
            return root;
        }
        //如果当前值小于根结点，插入到左子树
        if(curNode.val <= root.val){
            root.leftCount++;
            root.left = insert(root.left,curNode,res,i);
        }else{
            //如果大于根结点，结束计算，加入总和（注意加上自己）
            res[i] += root.leftCount + 1;
            root.right = insert(root.right,curNode,res,i);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        //预设为0
        for(int i: res) res[i] = 0;

        //
        TreeNode root = null;
        //从后往前遍历
        for(int i = nums.length - 1; i>= 0; i--){
            root = insert(root,new TreeNode(nums[i]),res,i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i: res) list.add(i);

        return list;
    }
}



// 当数据规模过大时，没法通过
//class Solution {
//    public List<Integer> countSmaller(int[] nums) {
//        int[] temp = new int[nums.length];
//
//        for(int i = 0; i < nums.length-1; i++){
//            int count = 0;
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i] > nums[j]){
//                    count++;
//                }
//            }
//            temp[i] = count;
//        }
//
//        List<Integer> res = new ArrayList<Integer>(temp.length);
//        for(int i: temp){
//            res.add(i);
//        }
//
//        return res;
//    }
//}
public class MainClass {
}
