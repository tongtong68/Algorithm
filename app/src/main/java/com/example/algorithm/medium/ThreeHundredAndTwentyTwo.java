package com.example.algorithm.medium;

import java.util.Arrays;

public class ThreeHundredAndTwentyTwo {

    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    // 方法一：搜索回溯
    // 时间复杂度：O(S^n)
    // 空间复杂度：O(n)
    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

    // 方法二：动态规划-自上而下
    // 时间复杂度：O(Sn)
    // 空间复杂度：O(S)
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange2(coins, amount, new int[amount]);
    }

    private int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}