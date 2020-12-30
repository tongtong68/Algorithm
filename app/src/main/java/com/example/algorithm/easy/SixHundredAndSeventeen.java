package com.example.algorithm.easy;

import com.example.algorithm.structure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SixHundredAndSeventeen {

    // 方法一：深度优先搜索
    // 时间复杂度：O(min(m,n))
    // 空间复杂度：O(min(m,n))
    public BinaryTree.TreeNode mergeTrees(BinaryTree.TreeNode t1, BinaryTree.TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        BinaryTree.TreeNode merged = new BinaryTree.TreeNode(t1.value + t2.value);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    private void dfs(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    // 方法一：广度优先搜索
    // 时间复杂度：O(min(m,n))
    // 空间复杂度：O(min(m,n))
    public BinaryTree.TreeNode mergeTrees2(BinaryTree.TreeNode t1, BinaryTree.TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        BinaryTree.TreeNode merged = new BinaryTree.TreeNode(t1.value + t2.value);
        Queue<BinaryTree.TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
        Queue<BinaryTree.TreeNode> queue1 = new LinkedList<BinaryTree.TreeNode>();
        Queue<BinaryTree.TreeNode> queue2 = new LinkedList<BinaryTree.TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            BinaryTree.TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            BinaryTree.TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    BinaryTree.TreeNode left = new BinaryTree.TreeNode(left1.value + left2.value);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    BinaryTree.TreeNode right = new BinaryTree.TreeNode(right1.value + right2.value);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}
