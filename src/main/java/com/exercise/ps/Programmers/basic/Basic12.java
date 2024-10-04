package com.exercise.ps.Programmers.basic;

public class Basic12 {
    public int solution(String myString, String pat) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()) {
            if(c == 'A')
                sb.append('B');
            else
                sb.append('A');
        }

        String str = sb.toString();
        if(str.contains(pat))
            answer = 1;

        return answer;
    }
}
