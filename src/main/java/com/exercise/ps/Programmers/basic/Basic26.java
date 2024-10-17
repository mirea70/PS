package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic26 {
    public String[] solution(String[] todo_list, boolean[] finished) {

        List<String> list = new ArrayList<>();
        for(int i=0; i<todo_list.length; i++) {
            if(!finished[i]) list.add(todo_list[i]);
        }

        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
