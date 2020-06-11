package com.ibairah.Medium.lc105ConstructBinaryTreePreorderandInorderTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ibairah on 6/10/20.
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart,
                inIndex - 1, preorder, inorder);
        // preStart + inIndex - inStart + 1 --> 头 + （inIndex是preoder的头位置-前面左子树的部分+1）
        root.right = helper(preStart + inIndex - inStart + 1,
                inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

// Method 2： 迭代
class Solution2 {
    // Iterative.
    // Simulate the preorder traversal, backtrack with inorder.

    // In preorder traversal, we start from root, go left until reaching left most node (pushing nodes to stack along the path), and then
    // backtrack to the first node with non-null right child, go to its right child and repeat.

    // Note the backtracking is entirely following the inorder, which gives us a way to locate the first node with non-null right child,
    // i.e. keep poping stack top if it's equal to next inorder value, the next preorder val is just the right child of last poped node.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int n = preorder.length;
        TreeNode lastPoped = null;
        for (int i = 1, j = 0; i < n; i++) {
            // backtracking following inorder, need to backtrack at the beginning
            // since we already pushed root node into stack before the loop
            while (j < n && !stack.isEmpty() && stack.peek().val == inorder[j]) {
                lastPoped = stack.pop();
                j++;
            }
            TreeNode curr = new TreeNode(preorder[i]);
            if (lastPoped == null) {
                // still going left
                stack.peek().left = curr;
            } else {
                // backtracked to lastPoped and going right
                lastPoped.right = curr;
            }
            stack.push(curr);
            lastPoped = null;
        }
        return root;
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