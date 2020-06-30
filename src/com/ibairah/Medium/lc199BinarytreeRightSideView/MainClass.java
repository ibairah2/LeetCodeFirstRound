package com.ibairah.Medium.lc199BinarytreeRightSideView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Created by ibairah on 6/29/20.
 * Given a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from
 * top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
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

// // DFS
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//       List<Integer> res = new ArrayList<>();
//       helper(root,res,0);
//       return res;
//     }

//     private void helper(TreeNode root, List<Integer> res, int depth){
//       if(root == null) return;
//       if(depth == res.size()) res.add(root.val);
//       helper(root.right,res,depth+1);
//       helper(root.left,res,depth+1);
//     }
// }
// BFS 利用Queue来做,更难理解
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        if(root == null) return res;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                TreeNode cur_node = q.poll();
                if( i == 0) res.add(cur_node.val);
                if(cur_node.right != null) q.offer(cur_node.right);
                if(cur_node.left != null) q.offer(cur_node.left);
            }
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