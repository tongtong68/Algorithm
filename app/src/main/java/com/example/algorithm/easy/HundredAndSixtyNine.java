package com.example.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

public class HundredAndSixtyNine {

    public Map<Integer, Integer> getMultipleNum(int[] nums) {

        Map<Integer, Integer> a = new HashMap<>();
        int times = 0;
        for (int num:nums) {
            if (!a.containsKey(num)) {
                a.put(num, 1);
            } else {
                a.put(num, a.get(num) + 1);
            }
        }

        return a;
    }


    // 方法一：哈希表
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = getMultipleNum(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    // 方法五：Boyer-Moore 投票算法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
