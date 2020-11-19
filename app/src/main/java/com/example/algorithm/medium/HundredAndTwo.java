package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HundredAndTwo {


    // 队列
    // 时间复杂度为 O(n)
    // 空间复杂度为 O(n)
    public List<Integer> levelOrder(BinaryTree.TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Deque<BinaryTree.TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTree.TreeNode peak = queue.poll();
            result.add(peak.value);
            if (peak.left != null) {
                queue.offer(peak.left);
            }
            if (peak.right != null) {
                queue.offer(peak.right);
            }
        }


        return result;
    }

    public List<List<Integer>> levelOrder2(BinaryTree.TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<BinaryTree.TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                BinaryTree.TreeNode node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
