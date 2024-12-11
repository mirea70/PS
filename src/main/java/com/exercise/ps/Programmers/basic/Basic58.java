package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic58 {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        // List
        List<String> list = new ArrayList<>();
        // strArr 순회
        for(String str : strArr) {
            // ad 포함하면 list에 추가
            if(!str.contains("ad"))
                list.add(str);
        }

        // list를 배열로 변환해서 반환
        return list.toArray(new String[list.size()]);
    }
}
