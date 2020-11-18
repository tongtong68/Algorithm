package com.example.algorithm.easy;

import com.example.algorithm.structure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HundredAndOne {

    // 方法一：递归
    // 时间复杂度： O(n)O(n)
    // 空间复杂度O(n)
    public boolean isSymmetric(BinaryTree.TreeNode root) {
        return check(root, root);
    }

    public boolean check(BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value && check(p.left, q.right) && check(p.right, q.left);
    }

    // 方法二：迭代
    // 时间复杂度：O(n)O(n)
    // 空间复杂度：O(n)O(n)
    public boolean isSymmetric2(BinaryTree.TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(BinaryTree.TreeNode u, BinaryTree.TreeNode v) {
        Queue<BinaryTree.TreeNode> q = new LinkedList<BinaryTree.TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.value != v.value)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
