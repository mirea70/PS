package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic93 {
    public String[] solution(String myStr) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(int i=0; i<myStr.length(); i++) {
            char ch = myStr.charAt(i);
            if(ch != 'a' && ch != 'b' && ch != 'c') {
                sb.append(ch);
            }
            else {
                if(sb.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if(sb.length() > 0)
            list.add(sb.toString());
        if(list.isEmpty())
            list.add("EMPTY");

        return list.toArray(new String[list.size()]);
    }
}
