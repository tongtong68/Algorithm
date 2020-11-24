package com.example.algorithm.difficult;

import com.example.algorithm.structure.BinaryTree;

public class HundredAndTwentyFour {

    public int maxSum = Integer.MIN_VALUE;


    // 方法一：递归
    // 时间复杂度：O(N)
    // 时间复杂度：O(N)
    public int getMaxWay(BinaryTree.TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(getMaxWay(root.left), 0);
        int right = Math.max(getMaxWay(root.right), 0);
        int result = root.value + left + right;
        maxSum = Math.max(maxSum, result);

        return root.value + Math.max(left, right);
    }
}
