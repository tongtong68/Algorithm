package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

public class ThreeHundredAndThirtySeven {

    // f(root)=max(root.val+f(ll)+f(lr)+f(rl)+f(rr),f(l)+f(r))
    // 暴力求解
    public int getMaxValue(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.value;
        }

        int result = getMaxValue(root.left) + getMaxValue(root.right);
        int result1 = root.value + getMaxValue(root.left.left) + getMaxValue(root.left.right) + getMaxValue(root.right.left) + getMaxValue(root.right.right);

        return Math.max(result, result1);
    }

    // 方法一：动态规划
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public int rob1(BinaryTree.TreeNode root) {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs1(BinaryTree.TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs1(node.left);
        int[] r = dfs1(node.right);
        int selected = node.value + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
