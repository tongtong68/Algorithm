package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

public class FiveHundredAndThirtyEight {

    int count = 0;
    int sum = 0;
//    public BinaryTree.TreeNode convertBST(BinaryTree.TreeNode root) {
//
//        dfs(root);
//        int val = count + root.value;
//    }

    private void dfs(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        count += root.value;
        dfs(root.left);
        dfs(root.right);
    }

    // 方法一：反序中序遍历
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public BinaryTree.TreeNode convertBST(BinaryTree.TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.value;
            root.value = sum;
            convertBST(root.left);
        }
        return root;
    }
}