package com.ibairah.Medium.lc129SumRoottoLeafNumbers;

/**
 * Created by ibairah on 6/26/20.
 *
 * Given a binary tree containing digits from 0-9 only, each
 * root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the
 * number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */


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
    int res;
    public int sumNumbers(TreeNode root) {
        //1. corner case
        if( root == null) return 0;
        res = 0;
        helper(root,0);
        return res;
    }
    private void helper(TreeNode root, int prev){
        //corner case
        if(root == null) return;

        //之前的数*10 + 当前的数
        prev = prev * 10 + root.val;

        //2. exit when both left and right root is empty
        //当所有叶子数为空，加上总和
        if(root.left == null && root.right ==null){
            res += prev;
            return;
        }
        //3. if current root is not leaf， which means is not end， we do DFS
        helper(root.left,prev);
        helper(root.right,prev);
    }
}

public class MainClass {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}