package com.example.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

public class TwoHundredAndEightySeven {


    public int searchDuplicate(int[] nums) {

        Set<Integer> result = new HashSet<>();
        for (int num:nums) {
            if (result.contains(num)) {
                return num;
            } else {
                result.add(num);
            }
        }

        return Integer.MAX_VALUE;
    }

    // 方法三：快慢指针
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}