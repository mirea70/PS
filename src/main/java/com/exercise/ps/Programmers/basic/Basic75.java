package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basic75 {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : myString.toCharArray()) {
            if(c != 'x')
                sb.append(c);
            else {
                if(sb.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if(sb.length() > 0) {
            list.add(sb.toString());
            sb.setLength(0);
        }

        Collections.sort(list);

        return list.toArray(new String[list.size()]);
    }
}
