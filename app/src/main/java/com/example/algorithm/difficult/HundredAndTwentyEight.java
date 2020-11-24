package com.example.algorithm.difficult;

import java.util.HashSet;
import java.util.Set;

public class HundredAndTwentyEight {

    int[] num = new int[] {10, 3, 2, 67, 1, 4, 8};


    // 方法一：哈希表
    // 时间复杂度为 O(n)
    // 空间复杂度 O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
