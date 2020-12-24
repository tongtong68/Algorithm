package com.example.algorithm.medium;

public class FourHundredAndSixteen {

    int[] nums = new int[]{1, 5, 5, 11};

    // 对于动态规划问题，我们只要抓住两个要素即可：状态、选择。
    public boolean isSplitTwo(int[] nums) {
        boolean result = false;
        int sum = 0;
        for (int num:nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        return result;
    }

    // 方法一：动态规划
    // 时间复杂度：O(n×target)
    // 空间复杂度：O(target)
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
