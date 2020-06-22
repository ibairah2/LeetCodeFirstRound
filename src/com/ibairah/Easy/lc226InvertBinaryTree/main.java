package com.ibairah.Easy.lc226InvertBinaryTree;

/**
 * Created by ibairah on 5/17/20.
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 */
public class main {
    public static void main(String[] args) {
        Solution sl = new Solution();
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

class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left= left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode right = invertTree(root.right); // 每次一调换之后把下面的子节点变为头结点
        // 比如2，7调换位置，2和7分别变成root
        TreeNode left = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
