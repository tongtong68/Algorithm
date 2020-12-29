package com.example.algorithm.easy;

import com.example.algorithm.structure.BinaryTree;

public class FiveHundredAndFortyThree {
    int ans;

    // 方法一：深度优先搜索
    // 时间复杂度：O(N)
    // 空间复杂度：O(Height)
    public int diameterOfBinaryTree(BinaryTree.TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(BinaryTree.TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
