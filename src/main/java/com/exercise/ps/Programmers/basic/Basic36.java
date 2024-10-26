package com.exercise.ps.Programmers.basic;

public class Basic36 {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;

        if(my_string.length() >= is_prefix.length()) {
            for (int j = 0; j < is_prefix.length(); j++) {
                if (is_prefix.charAt(j) != my_string.charAt(j))
                    break;
                if (j == is_prefix.length() - 1)
                    answer = 1;
            }
        }

        return answer;
    }
}
