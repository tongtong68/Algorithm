package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortyNine {
    private String[] tmp = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

    public void getResult(String[] strings) {
        Map a = new HashMap();
        Map b = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            String temp = strings[i];
            Arrays.sort(strings[i].toCharArray());
            a.put(temp, strings[i]);
        }
    }

    // 排序数组分类
    // 时间复杂度O (NKLogK)
    // 空间复杂度O (NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    // 按计数分类
    // 时间复杂度 O(NK)
    // 空间复杂度 O(NK)
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
