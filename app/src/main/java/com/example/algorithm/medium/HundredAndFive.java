package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class HundredAndFive {

    private Map<Integer, Integer> indexMap;

    public BinaryTree.TreeNode myBuildTree(int[] preOrder, int[] inOrder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inorderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preOrderRoot = preOrderLeft;
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preOrder[preOrderRoot]);

        // 先把根节点建立出来
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(preOrder[preOrderRoot]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inOrderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preOrder, inOrder, preOrderLeft + 1, preOrderLeft + sizeLeftSubtree, inOrderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preOrder, inOrder, preOrderLeft + sizeLeftSubtree + 1, preOrderRight, inorderRoot + 1, inorderRight);
        return root;
    }


    // 方法一：递归
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public BinaryTree.TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


}