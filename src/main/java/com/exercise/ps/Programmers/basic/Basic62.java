package com.exercise.ps.Programmers.basic;

public class Basic62 {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_strings.length; i++) {
            for(int j=parts[i][0]; j<=parts[i][1]; j++) {
                sb.append(my_strings[i].charAt(j));
            }
        }
        return sb.toString();
    }
}
