package com.exercise.ps.Programmers.basic;


import java.util.HashSet;
import java.util.Set;

public class Basic82 {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> delete_set = new HashSet<>();
        for(int i : indices)
            delete_set.add(i);

        for(int i=0; i<my_string.length(); i++) {
            if(!delete_set.contains(i))
                sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }
}
