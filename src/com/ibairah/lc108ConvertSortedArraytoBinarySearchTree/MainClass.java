package com.ibairah.lc108ConvertSortedArraytoBinarySearchTree;

/**
 * Created by ibairah on 6/10/20.
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a
 * binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents
 * the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if( nums.length == 0) return null;
        return DFS(nums, 0 ,nums.length-1);
    }

    public TreeNode DFS(int[] nums, int start, int end){
        //exit;
        if( start > end ) return null;
        //
        int mid = start + (end - start )/2 ;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = DFS(nums,start, mid-1);
        node.right = DFS(nums,mid+1, end);

        return node;
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
