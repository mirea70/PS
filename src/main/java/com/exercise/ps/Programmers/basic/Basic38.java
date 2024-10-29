package com.exercise.ps.Programmers.basic;

public class Basic38 {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;

        int my_string_idx = my_string.length()-1;

        if(my_string.length()>=is_suffix.length()) {
            for(int i=is_suffix.length()-1; i>=0; i--) {
                if(is_suffix.charAt(i) != my_string.charAt(my_string_idx))
                    break;
                if(i == 0)
                    answer = 1;
                my_string_idx--;
            }
        }

        return answer;
    }
}
