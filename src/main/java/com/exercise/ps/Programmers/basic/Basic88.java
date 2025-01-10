package com.exercise.ps.Programmers.basic;

public class Basic88 {
    public String solution(String myString, String pat) {
        String max_len_str = "";
        int len = myString.length();

        for(int i=0; i<len; i++) {
            for(int j=i+1; j<=len; j++) {
                String current = myString.substring(i, j);
                if(myString.endsWith(current) && current.length() > max_len_str.length())
                {
                    max_len_str = current;
                }
            }
        }

        return max_len_str;
    }
}
