package com.ibairah.lc617MergeTwoBtree;

/**
 * Created by ibairah on 5/26/20.
 * Given two binary trees and imagine that when you put one of them
 * to cover the other, some nodes of the two trees are overlapped
 * while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is
 * that if two nodes overlap, then sum node values up as the new
 * value of the merged node. Otherwise, the NOT null node will be
 * used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 * Note: The merging process must start from the root nodes of both
 * trees.
 */
public class MainClass {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;  // 如果t1空则返回t2
        if(t2 == null) return t1;  //

        t1.val = t1.val + t2.val; //注意这里是t1.val等于

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1; //t2没有操作是因为已经全部加到t1上去了
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */