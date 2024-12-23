package com.exercise.ps.Programmers.basic;

public class Basic70 {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()) {
            if(c < 'l')
                sb.append('l');
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
