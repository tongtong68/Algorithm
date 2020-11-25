package com.example.algorithm.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HundredAndThirtySix {

    int[] nums = new int[] {1, 1, 2, 2, 3};


    // 方法一：HashMap
    // 时间复杂度O(N)
    // 空间复杂度O(N)
    public int getResult(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                resultMap.remove(nums[i]);
            } else {
                resultMap.put(nums[i], i);
            }
        }
        for(Integer key : resultMap.keySet()) {
            result = key;
        }
        return result;
    }


    // 方法二：异或
    // 时间复杂度O(N)
    // 空间复杂度O(1)
    public int getResult2(int[] nums) {
        int result = 0;
        for (int num:nums) {
            result ^= num;
        }
        return result;
    }
}
