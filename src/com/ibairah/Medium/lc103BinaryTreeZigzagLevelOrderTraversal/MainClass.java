package com.ibairah.Medium.lc103BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ibairah on 6/10/20.
 *
 * Given a binary tree, return the zigzag level order traversal of
 * its nodes' values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */



class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null) return res;
        DFS(root,0,res);
        return res;
    }

    public void DFS(TreeNode root, int depth, List<List<Integer>> res) {
        // exit
        if(root == null) return;

        // handle
        if(depth > res.size()){
            //creating new lists when needed.
            res.add(new LinkedList<>());

        }
        if( depth % 2 == 0){
            res.get(depth).add(root.val);
            System.out.println(" 0 :"+ res);
        }else{
            // 当是奇数层的时候，把每次加入的数放在第一位
            res.get(depth).add(0,root.val);
        }

        DFS(root.left, depth+1, res);
        DFS(root.right, depth+1, res);

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