package com.exercise.ps.Programmers.basic;

public class Basic108 {
    public String solution(String my_string, int[][] queries) {
        String current = my_string;
        for(int i=0; i<queries.length; i++) {
            current = query(current, queries[i]);
        }

        return current;
    }

    private String query(String org, int[] query) {
        StringBuilder sb = new StringBuilder();
        sb.append(org.substring(query[0], query[1]+1));
        sb.reverse();
        sb.insert(0, org.substring(0, query[0]));
        if(org.length() >= query[1]+1)
            sb.append(org.substring(query[1]+1));

        return sb.toString();
    }
}
