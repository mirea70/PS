package com.exercise.ps.leetcode.dp;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int max_length = 0;
        for(String word : wordDict) {
            max_length = Math.max(max_length, word.length());
        }

        for(int i=1; i<=n; i++) {
            for(int j=i-1; j>=Math.max(0, i-max_length); j--) {
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
