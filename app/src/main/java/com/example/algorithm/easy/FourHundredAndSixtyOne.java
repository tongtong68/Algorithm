package com.example.algorithm.easy;

public class FourHundredAndSixtyOne {

    public int getHanMingDistance(int x, int y) {

        int result = x ^ y;
        char[] temp = Integer.toBinaryString(result).toCharArray();
        int count = 0;
        for (char a:temp) {
            if (a == '1') {
                count = count + 1;
            }
        }

        return count;
    }

    // 方法一：内置位计数功能
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 方法二：移位
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
