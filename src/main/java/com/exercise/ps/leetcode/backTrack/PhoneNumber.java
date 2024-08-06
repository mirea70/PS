package main.java.com.exercise.ps.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return list;

        dfs(digits, "", 0);
        return list;
    }

    private void dfs(String digits, String current, int depth) {
        if(depth == digits.length()) {
            list.add(current);
            return;
        }

        char[] letters = getLetters(digits.charAt(depth));
        for(int i=0; i<letters.length; i++) {
            dfs(digits, current + letters[i], depth+1);
        }
    }

    private char[] getLetters(char digit) {
        switch(digit) {
            case '2': return new char[]{'a','b','c'};
            case '3': return new char[]{'d','e','f'};
            case '4': return new char[]{'g','h','i'};
            case '5': return new char[]{'j','k','l'};
            case '6': return new char[]{'m','n','o'};
            case '7': return new char[]{'p','q','r', 's'};
            case '8': return new char[]{'t','u','v'};
            case '9': return new char[]{'w','x','y','z'};
        }
        return null;
    }
}
