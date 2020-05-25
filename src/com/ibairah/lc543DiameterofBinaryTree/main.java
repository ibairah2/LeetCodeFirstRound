package com.ibairah.lc543DiameterofBinaryTree;


/**
 * Created by ibairah on 5/18/20.
 * Given a binary tree, you need to compute the length
 * of the diameter of the tree. The diameter of a binary
 * tree is the length of the longest path between any two
 * nodes in a tree. This path may or may not pass through
 * the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by
 * the number of edges between them.
 */


//https://www.bilibili.com/video/BV1qA411t7LR?from=search&seid=2477625260393238233
public class main {
    public static void main(String[] args) {

    }
}
class Solution {
    //两个叶子节点的距离 = 根节点左右儿子的 深度 之和
    // DFS(深度优先搜索)-> 用递归函数对整个目标进行遍历
    // 比如求4-3距离,pseudo code: distance = depth（4->1） + depth（3->1）

    int ans;  // 设定一个全局变量
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null){ //递归出口
            return 0;
        }
        int L = depth(node.left); // 对左节点做同样的事
        int R = depth(node.right);// 对右节点做同样的事
        ans = Math.max(ans, L+R); // 每次递归比较大小，储存最大MAX
        System.out.println("Math.max(L, R) + 1 : "+ (Math.max(L, R) + 1));
        System.out.println("ans: "+ ans);

        return Math.max(L, R) + 1; // 当parent节点左右都为null时候返回此parent节点长度，
        //然后通过比较左右两边深度找出最大值；
        //比如1-左边为深度为3，右边深度为2，则1最长深度为3
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left , TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
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