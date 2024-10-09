package com.exercise.ps.Programmers.basic;

public class Basic18 {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()) {
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
}
