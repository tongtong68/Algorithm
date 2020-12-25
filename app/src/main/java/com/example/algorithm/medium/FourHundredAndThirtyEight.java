package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourHundredAndThirtyEight {

    // 暴力解法
    public List<Integer> getSubStringIndex(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> chas = new HashMap<>();
        char[] sorted = p.toCharArray();
        Arrays.sort(sorted);

        int len = sorted.length;
        for (int i = 0; i <= s.length() - len; i++) {
            boolean flag = true;
            char[] sub = s.substring(i, i + len).toCharArray();
            Arrays.sort(sub);

            for (int j = 0; j < len; j++) {
                if (sub[j] != sorted[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(i);
        }
        return res;
    }

    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0) return ans;

        int[] dict = new int[26];
        for (int i = 0; i < p.length(); i++) {
            dict[p.charAt(i) - 'a'] += 1;
        }

        int[] window = new int[26];
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int curR = s.charAt(right) - 'a';
            right++;
            window[curR] += 1;
            while (window[curR] > dict[curR]) {
                int curL = s.charAt(left) - 'a';
                window[curL] -= 1;
                left++;
            }
            if (right - left == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }
}