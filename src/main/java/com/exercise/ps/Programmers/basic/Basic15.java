package com.exercise.ps.Programmers.basic;

public class Basic15 {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();

        for(char c : my_string.toCharArray()) {
            char input = c;
            if(c == alp.charAt(0))
                input = Character.toUpperCase(c);
            sb.append(input);
        }

        return sb.toString();
    }
}
