package com.example.algorithm.medium;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

public class FiveHundredAndSixty {

    // 暴力法
    // 时间复杂度：O(n2)
    // 时间复杂度：O(1)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    // 方法二：前缀和 + 哈希表优化

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
