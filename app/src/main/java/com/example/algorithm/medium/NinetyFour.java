package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NinetyFour {

    // 方法一：递归
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<Integer> inorderTraversal(BinaryTree.TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    private void inorder(BinaryTree.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.value);
        inorder(root.right, res);
    }


    // 方法二：栈
    // 时间复杂度：O(n)O(n)
    // 空间复杂度：O(n)O(n)
    public List<Integer> inorderTraversal2(BinaryTree.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<BinaryTree.TreeNode> stack = new LinkedList<BinaryTree.TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.value);
            root = root.right;
        }
        return res;
    }

    // 方法三：Morris 中序遍历
    // 时间复杂度：O(n)O(n)
    // 空间复杂度：O(1)O(1)
    public List<Integer> inorderTraversal3(BinaryTree.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        BinaryTree.TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.value);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.value);
                root = root.right;
            }
        }
        return res;
    }
}
