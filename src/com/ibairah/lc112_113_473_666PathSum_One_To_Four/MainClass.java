package com.ibairah.lc112_113_473_666PathSum_One_To_Four;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 5/26/20.
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along the
 * path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2
 * which sum is 22.
 */

class Solution {
    public boolean hasPathSum112(TreeNode root, int sum) {
        if(root == null) return false;

        sum -= root.val;
        // 设置递归出口
        if(root.left == null && root.right == null) return sum == 0;

        // Tree 在 boolean 递归
        //先寻找左leaf
        return hasPathSum112(root.left, sum) || hasPathSum112(root.right, sum);
    }

    /**
    Given a binary tree and a sum, find all root-to-leaf paths
    where each path's sum equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
    Return:

    [
       [5,4,11,2],
       [5,8,4,5]
    ]
     */
    public List<List<Integer>> pathSum113(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>(){};
        dfs(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur_res) {
        //exist-1
        if(root == null) return ;
        // update sum
        sum -= root.val;
        // exist-2
        if(root.left == null && root.right ==null){
            if(sum == 0) { // 满足条件
                cur_res.add(root.val);

                // 为什么要加new !!!!!
                // 因为是为了做一个cur_res的new复制copy，因为之后每一次的
                //cur_res都会被remove掉
                res.add(new ArrayList<Integer>(cur_res)); //！！！！关键
                cur_res.remove(cur_res.size()-1);
            }
            return;
        }

        //拆解
        cur_res.add(root.val);  // 当他还不是leaf node的情况，也要先add
        cur_res.toString();
        dfs(root.left, sum, res, cur_res);
        dfs(root.right, sum, res, cur_res);
        cur_res.remove(cur_res.size()-1);
    }

    /**
    You are given a binary tree in which each node contains
    an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf,
     but it must go downwards (traveling only from parent
      nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are
    in the range -1,000,000 to 1,000,000.

    Example:

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

    Return 3. The paths that sum to 8 are:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11
     */


    //https://www.youtube.com/watch?v=EE8S0pAi_dM&t=52s
    public int pathSum437(TreeNode root, int sum) {
        if(root == null ) return 0;
        //每一个节点都能从未root，所以计算时每一个节点都要设置一遍
        return dfs437(root,sum)+ pathSum437(root.left, sum)
                + pathSum437(root.right, sum);
    }

    private int dfs437(TreeNode root, int sum) {
        //exist
        if(root == null) return 0;

        sum -= root.val;

        // root + left + right
        //返回的是 左边的情况+右边的情况+当前这个root是否满足条件
        return (sum == 0 ? 1 : 0) + dfs437(root.left, sum)+
                dfs437(root.right, sum);
    }

    //更容易理解的办法，每次计算路线，再分别从所有点计算
    public int pathSum437_method2(TreeNode root, int sum) {
        if(root == null ) return 0;
        //每一个节点都能从未root，所以计算时每一个节点都要设置一遍
        return dfs437_method2(root,sum)+
                pathSum437_method2(root.left, sum)+
                pathSum437_method2(root.right, sum);
    }

    private int dfs437_method2(TreeNode root, int sum) {
        //exist
        if(root == null) return 0;

        int counter = 0;

        if(root.val == sum){
            counter += 1;
        }
        sum -= root.val;
        counter += dfs437_method2(root.left,sum);
        counter += dfs437_method2(root.right, sum);

        return counter;
    }
}

public class MainClass {
    public static void main(String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
