package com.exercise.ps.leetcode.window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        char[] arr = s.toCharArray();
        int max = 0;

        while(right < len) {
            if(!set.contains(arr[right])) {
                set.add(arr[right]);
                max = Math.max(max, set.size());
            }
            else {
                while(set.contains(arr[right])) {
                    set.remove(arr[left]);
                    left++;
                }
                set.add(arr[right]);
            }
            // System.out.print(set.toString());
            right++;
        }
        return max;
    }
}
