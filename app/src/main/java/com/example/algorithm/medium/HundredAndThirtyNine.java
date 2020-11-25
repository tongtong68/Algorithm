package com.example.algorithm.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HundredAndThirtyNine {

    // 动态规划
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
