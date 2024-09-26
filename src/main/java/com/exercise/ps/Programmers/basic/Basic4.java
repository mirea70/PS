package com.exercise.ps.Programmers.basic;

public class Basic4 {
    public int solution(String n_str) {
        int answer = 0;

        for(char c : n_str.toCharArray())
            answer += c - '0';

        return answer;
    }
}
