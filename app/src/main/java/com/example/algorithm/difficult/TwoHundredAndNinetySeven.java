package com.example.algorithm.difficult;

import com.example.algorithm.structure.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoHundredAndNinetySeven {

    // 方法一：深度优先搜索
    // 时间复杂度为 O(n)
    // 空间复杂度为 O(n)
    public String serialize(BinaryTree.TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(BinaryTree.TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.value) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // 方法一：深度优先搜索
    // 时间复杂度为 O(n)
    // 空间复杂度为 O(n)
    public BinaryTree.TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    private BinaryTree.TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        BinaryTree.TreeNode root = new BinaryTree.TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

}
