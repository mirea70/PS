package com.exercise.ps.Programmers.basic;

public class Basic11 {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        for(char c : rny_string.toCharArray()) {
            String input = String.valueOf(c);
            if(c == 'm')
                input = "rn";
            sb.append(input);
        }

        return sb.toString();
    }
}
