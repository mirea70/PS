package com.exercise.ps.Programmers.basic;

public class Basic45 {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i< numLog.length; i++) {
            sb.append(extract(numLog[i-1], numLog[i]));
        }
        return sb.toString();
    }

    private char extract(int before, int after) {
        int standard = after - before;

        switch (standard) {
            case 1: return 'w';
            case -1: return 's';
            case 10: return 'd';
            case -10: return 'a';
            default: return 'q';
        }
    }
}
