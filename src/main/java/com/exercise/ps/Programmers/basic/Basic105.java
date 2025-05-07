package com.exercise.ps.Programmers.basic;

public class Basic105 {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for(int i=0; i<my_string.length(); i++) {
            char val = my_string.charAt(i);
            if(Character.isUpperCase(val))
                answer[val - 'A']++;
            else
                answer[val - 'A' - 6]++;

        }

        return answer;
    }
}
