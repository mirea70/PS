package com.exercise.ps.Programmers.basic;

public class Basic19 {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()) {
            sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }
}
