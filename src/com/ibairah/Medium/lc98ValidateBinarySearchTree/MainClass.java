package com.ibairah.Medium.lc98ValidateBinarySearchTree;

/**
 * Created by ibairah on 6/10/20.
 *
 * Given a binary tree, determine if it is a valid binary search
 * tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less
 * than the node's key.
 * The right subtree of a node contains only nodes with keys
 * greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's
 * value is 4.
 *
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if( root == null) return true;
        return DFS(root,null,null);
    }


    public boolean DFS(TreeNode root, Integer maxV, Integer minV){
        // exit 1;
        if( root == null ) return true;

        // exit 2;
        if((maxV != null && root.val >= maxV) || (minV != null && root.val <= minV) ) return false;

        Boolean left = DFS(root.left, root.val, minV); //每个左子树当前最大值是他的root
        Boolean right = DFS(root.right, maxV, root.val);//每个右子数当前最小值是他的root
        return left && right;
    }
}

public class MainClass {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
