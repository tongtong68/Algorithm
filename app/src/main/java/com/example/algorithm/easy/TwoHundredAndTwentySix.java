package com.example.algorithm.easy;

import com.example.algorithm.structure.BinaryTree;

public class TwoHundredAndTwentySix {

    // 递归
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public void reverseTree(BinaryTree.TreeNode root) {

        if (root == null) {
            return ;
        }
        reverseTree(root.left);
        reverseTree(root.right);

        BinaryTree.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
