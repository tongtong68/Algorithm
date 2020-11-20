package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HundredAndFourteen {


    // 方法一：前序遍历(递归)
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public BinaryTree getLinkedListTree(BinaryTree.TreeNode root) {
        List<BinaryTree.TreeNode> result = new ArrayList<>();

        result = preOrderTree(root, result);
        for (int i = 0; i < result.size(); i++) {
            result.get(i).left = null;
            if (i < result.size() - 1) {
                result.get(i).right = result.get(i+1);
            } else {
                result.get(i).right = null;
            }
        }

        return new BinaryTree(result.get(0));
    }

    private List<BinaryTree.TreeNode> preOrderTree(BinaryTree.TreeNode root, List<BinaryTree.TreeNode> result) {
        if (root == null) {
            return null;
        }

        result.add(root);
        preOrderTree(root.left, result);
        preOrderTree(root.right, result);
        return result;
    }

    // 方法一：前序遍历(迭代)
    public BinaryTree getLinkedListTree2(BinaryTree.TreeNode root) {
        List<BinaryTree.TreeNode> list = new ArrayList<BinaryTree.TreeNode>();
        Deque<BinaryTree.TreeNode> stack = new LinkedList<BinaryTree.TreeNode>();
        BinaryTree.TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            BinaryTree.TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
        return new BinaryTree(list.get(0));
    }

    // 方法二：前序遍历和展开同步进行
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public void getLinkedListTree3(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<BinaryTree.TreeNode> stack = new LinkedList<BinaryTree.TreeNode>();
        stack.push(root);
        BinaryTree.TreeNode prev = null;
        while (!stack.isEmpty()) {
            BinaryTree.TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            BinaryTree.TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }
}
