package com.ibairah.Medium.lc102BinaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * Created by ibairah on 6/10/20.
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        BFS(root, res, 0);
        return res;
    }

    public void BFS(TreeNode root, List<List<Integer>> res, int depth) {
        // exit;
        if (root == null) {
            System.out.println("到达出口");
            return;
        }

        //!!!!!!!!!
        //that check of height>=res.size() makes sure extra LinkedList is not added to res!
        if (depth >= res.size()) {
            res.add(new LinkedList<Integer>());
        }

        res.get(depth).add(root.val);  // 添加中间
        System.out.println("res: " + res);

        BFS(root.left, res, depth + 1);  // 添加左边

        System.out.println("To right");

        BFS(root.right, res, depth + 1); // 添加右边


        return;
    }

    // Method2: queue method
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 提前添加头结点来形成循环

        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            // counter计算当前行有多少个数
            int counter = queue.size();
            for (int i = 0; i < counter; i++) {
                TreeNode node = queue.pop(); //提取出当前头结点
                current.add(node.val);

                //查找左右子树
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(current);
        }
        return res;
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
}
public class MainClass {
}


