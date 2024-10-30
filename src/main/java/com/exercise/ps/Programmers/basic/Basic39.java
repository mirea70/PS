package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic39 {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        String temp = "";

        int index = 0;
        for(int i=my_string.length()-1; i>=0; i--) {
            temp = my_string.charAt(i) + temp;
            answer[index++] = temp;
        }
        Arrays.sort(answer);

        return answer;
    }
}
