package com.example.algorithm.easy;

public class Seventy {
    private int n;

    public int getResult(int n) {
        int result = 0;
        if (n <= 0) {
            return  1;
        }
        if (n == 1) {
            return  1;
        }

        result = getResult(n-1) + getResult(n-2);

        return result;
    }

    //  动态规划
    //  时间复杂度为 O(n)
    //  空间复杂度为 O(1)
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}