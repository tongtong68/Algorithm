package com.example.algorithm.medium;

public class ThreeHundredAndThirtyEight {


    // 暴力法
    // 时间复杂度：O(Nsizeof(num))
    // 空间复杂度：O(N)
    public int[] getNums(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int a = getOne(i);
            result[i] = a;
        }

        return result;
    }

    private int getOne(int n) {
        String a = Integer.toBinaryString(n);
        int count = 0;
        for (char temp:a.toCharArray()) {
            if (temp == '1') {
                count++;
            }
        }

        return count;
    }

    //
    public int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }
        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int a = getOne1(i);
            result[i] = a;
        }

        return result;
    }

    private int getOne1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return getOne1(n / 2);
        } else {
            return getOne1(n -1) + 1;
        }
    }

    // 方法三：动态规划 + 最低有效位
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}