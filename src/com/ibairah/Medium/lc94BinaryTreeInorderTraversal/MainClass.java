package com.ibairah.Medium.lc94BinaryTreeInorderTraversal;

/**
 * Created by ibairah on 6/10/20.
 * Given a binary tree, return the inorder traversal of its nodes'
 * values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it
 * iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList<Integer>();
        DFS(root,res);
        return res;
    }

    public void DFS(TreeNode root, List<Integer> res){
        //exit
        if( root == null) return;
        //
        DFS(root.left,res);  // 添加左边
        res.add(root.val);   // 左边加完后，加自己
        DFS(root.right,res); // 添加右边
    }


    //System.out.println("---------Divided Line-----------" );
    // Follow Up - Iterate method
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
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


public class MainClass {
}
