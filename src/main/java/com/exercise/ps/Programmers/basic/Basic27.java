package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic27 {
    public String[] solution(String[] names) {

        List<String> list = new ArrayList<>();
        int priority = 1;

        for(int i=0; i<names.length; i++) {
            if(priority == 6)
                priority = 1;

            if(priority == 1)
                list.add(names[i]);
            priority++;
        }

        String[] arr = new String[list.size()];
        for(int i=0; i<list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }
}
