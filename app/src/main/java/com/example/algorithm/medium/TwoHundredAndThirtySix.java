package com.example.algorithm.medium;

import com.example.algorithm.structure.BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoHundredAndThirtySix {

    private BinaryTree.TreeNode ans;

    Map<Integer, BinaryTree.TreeNode> parent = new HashMap<Integer, BinaryTree.TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TwoHundredAndThirtySix() {
        this.ans = null;
    }

    private boolean dfs(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.value == p.value || root.value == q.value) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.value == p.value || root.value == q.value);
    }

    // 方法一：递归
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public BinaryTree.TreeNode lowestCommonAncestor(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private void dfs(BinaryTree.TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.value, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.value, root);
            dfs(root.right);
        }
    }

    // 方法二：存储父节点
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public BinaryTree.TreeNode lowestCommonAncestor2(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.value);
            p = parent.get(p.value);
        }
        while (q != null) {
            if (visited.contains(q.value)) {
                return q;
            }
            q = parent.get(q.value);
        }
        return null;
    }
}