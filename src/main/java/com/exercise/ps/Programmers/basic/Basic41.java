package com.exercise.ps.Programmers.basic;

public class Basic41 {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for(int i : index_list) {
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}
