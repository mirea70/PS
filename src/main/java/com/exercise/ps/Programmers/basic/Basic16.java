package com.exercise.ps.Programmers.basic;

public class Basic16 {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for(char c : myString.toCharArray()) {
            char input = c;
            if(c == 'a')
                input = Character.toUpperCase(c);
            else {
                if(c != 'A' && Character.isUpperCase(c))
                    input = Character.toLowerCase(c);
            }

            sb.append(input);
        }

        return sb.toString();
    }
}
