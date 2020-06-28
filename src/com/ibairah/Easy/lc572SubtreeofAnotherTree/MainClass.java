package com.ibairah.Easy.lc572SubtreeofAnotherTree;

/**
 * Created by ibairah on 6/28/20.
 *
 * Given two non-empty binary trees s and t, check whether tree t
 * has exactly the same structure and node values with a subtree of
 * s. A subtree of s is a tree consists of a node in s and all of
 * this node's descendants. The tree s could also be considered as
 * a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values
 * with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)return false;
        //先序遍历确认root是否相同
        if ( isSame(s,t) ) return true;
        //再遍历他的左子数或者右子数确认起点，因为是确定起点所以是不可能左右两边同时都有
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
            //如果出现有一个节点长度不相等
        else if ( s == null || t == null) return false;
            //当满足root相等，找左节点，再找右节点
        else return s.val == t.val && isSame(s.left,t.left) && isSame(s.right,t.right);
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
