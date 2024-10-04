package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Basic14 {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens())
            list.add(st.nextToken());

        String[] arr = new String[list.size()];

        for(int i=0; i<list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }
}
