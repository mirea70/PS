package main.java.com.exercise.ps.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            int value = map.getOrDefault(ch, 0);
            map.put(ch, value + 1);
        }

        for(char c : ransomNote.toCharArray()) {
            int value = map.getOrDefault(c, 0);
            if(value == 0) return false;
            map.put(c, value - 1);
        }
        return true;
    }
}
