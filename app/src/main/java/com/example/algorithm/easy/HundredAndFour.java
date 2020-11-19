package com.example.algorithm.easy;

import com.example.algorithm.structure.BinaryTree;

public class HundredAndFour {

    public int maxDepth(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
