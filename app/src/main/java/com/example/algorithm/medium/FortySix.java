package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FortySix {

    private int[] example = new int[]{1, 2, 3};

    // 回溯
    // 时间复杂度：O(n*n!)
    // 空间复杂度：O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    // 回溯
    // 时间复杂度：O(n*n!)
    // 空间复杂度：O(n)
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>(); //结果变量

        if (nums == null || nums.length == 0) {
            return res;
        }

        boolean[] used = new boolean[nums.length]; //表示nums中的每位数字是否已经使用
        Arrays.fill(used, false); //全部数字都没有使用
        List<Integer> sub = new LinkedList<>(); //每一种组合

        generate(nums, res, sub, used);

        return res;
    }

    /**
     * 生成全排列
     *
     * @param nums 全排列的数字
     * @param res  结果变量
     * @param sub  每一种组合
     * @param used 对应nums中的每位数字是否已经使用
     */
    private void generate(int[] nums, List<List<Integer>> res, List<Integer> sub, boolean[] used) {
        /*如果是一种组合了，就是没有可用的数字了*/
        if (nums.length == sub.size()) {
            res.add(new LinkedList(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果这一位数字已经使用了
            if (used[i] == true) {
                continue;
            }

            used[i] = true; //标明这个数字已经使用了
            sub.add(nums[i]);
            generate(nums, res, sub, used);
            sub.remove(sub.size() - 1);
            used[i] = false; //标明这个数字没有使用
        }
    }

}
