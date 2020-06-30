package com.ibairah.Medium.lc314BinaryTreeVerticalOrderTraversal;

/**
 * Created by ibairah on 6/29/20.
 *
 * Given a binary tree, return the vertical order traversal of its
 * nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be
 * from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2
 * and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    //为了确定从左到右的长度
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //1.corner case
        if(root == null) return res;

        //2.dfs来更新长度
        dfs(root,0);

        //3.从左往右初始化res
        for(int i = min; i <= max; i++){
            res.add(new ArrayList<>());
        }

        //4.Queue来存储 root和他的index
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.offer(root);
        //！！！！！！！
        //因为每次往左找会-1，为了满足List中不为负数，则至少提供-min个空位
        index.offer(-min);

        //5.BFS
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int cur_idx = index.poll();
            //！！获取当前的位置加入当前值
            res.get(cur_idx).add(cur.val);
            //每次往左更新 -1
            if(cur.left != null){
                q.offer(cur.left);
                index.offer(cur_idx-1);
            }
            //每次往右更新 +1
            if(cur.right != null){
                q.offer(cur.right);
                index.offer(cur_idx+1);
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int index){
        //exit
        if(root == null) return;
        min = Math.min(min,index);
        max = Math.max(max,index);
        dfs(root.left,index - 1); // 左边-1
        dfs(root.right,index + 1); // 右边+1
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