package com.ibairah.Easy.lc107BinaryTreeLevelOrderTraversalII;

/**
 * Created by ibairah on 7/2/20.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int counter = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                cur.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            res.add(0,cur);
        }
        return res;
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