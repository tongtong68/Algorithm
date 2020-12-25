package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourHundredAndThirtyEight {

    // 暴力解法
    // 时间复杂度：O(pLength * sLength)
    // 空间复杂度：O(1)
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
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public List<Integer> findAnagrams(String s, String p) {
        // 先对目标串p每个字符进行字符计数，统计出每个字符的出现次数
        int pLength = p.length();
        int sLength = s.length();

        int[] counts = new int[26];
        for (int i = 0; i < pLength; i++) {
            counts[p.charAt(i) - 'a']++;
        }

        ArrayList<Integer> res = new ArrayList<>();  // 存储结果的结果集

        int[] tempCounts = new int[26]; // 记录窗口内每种字符的出现次数
        int left = 0, right = 0;
        while (right < sLength) {
            int curR = s.charAt(right) - 'a';
            tempCounts[curR]++;        // curR字符的出现次数加一
            right++;    // 新增一个字符后，窗口右指针右移一位
            while (tempCounts[curR] > counts[curR]) { // 不断缩小窗口大小，直到把超标字符移出去一个，使得不超标
                tempCounts[s.charAt(left) - 'a']--;
                left++;     // 移走一个字符后窗口左指针右移一位
            }
            if (right - left == pLength) {
                res.add(left);
            }
        }
        return res;
    }
}