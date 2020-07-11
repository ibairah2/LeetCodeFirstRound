package com.ibairah.Medium.lc662MaximumWidthofbinaryTree;

/**
 * Created by ibairah on 7/9/20.
 *
 * Given a binary tree, write a function to get the maximum width
 * of the given tree. The width of a tree is the maximum width
 * among all levels. The binary tree has the same structure as a
 * full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the
 * end-nodes (the leftmost and right most non-null nodes in the
 * level, where the null nodes between the end-nodes are also
 * counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with
 * the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with
 * the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with
 * the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with
 * the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */

import java.util.LinkedList;
import java.util.List;

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
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new LinkedList<>();
        helper(root, 0, 0, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println("root: "+ root.val);
        System.out.println("size: "+list.size());
        System.out.println("level: "+ level);

        if (level == list.size()) list.add(index);
        System.out.println("list:"+list.toString());
        System.out.println("get level:"+list.get(level));
        System.out.println("index:"+index);
        System.out.println("-----------------");

        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }
}

public class MainClass {
}

//[1,3,2,5,3,null,9]

//        root: 1
//        size: 0
//        level: 0
//        list:[0]
//        get level:0
//        index:0
//        -----------------
//        root: 3
//        size: 1
//        level: 1
//        list:[0, 0]
//        get level:0
//        index:0
//        -----------------
//        root: 5
//        size: 2
//        level: 2
//        list:[0, 0, 0]
//        get level:0
//        index:0
//        -----------------
//        null
//        null
//        root: 3
//        size: 3
//        level: 2
//        list:[0, 0, 0]
//        get level:0
//        index:1
//        -----------------
//        null
//        null
//        root: 2
//        size: 3
//        level: 1
//        list:[0, 0, 0]
//        get level:0
//        index:1
//        -----------------
//        null
//        root: 9
//        size: 3
//        level: 2
//        list:[0, 0, 0]
//        get level:0
//        index:3
//        -----------------
//        null
//        null



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

