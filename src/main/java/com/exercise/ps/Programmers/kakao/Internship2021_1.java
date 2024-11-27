package com.exercise.ps.Programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class Internship2021_1 {
    public int solution(String s) {
        int answer = 0;
        boolean flag = false;
        StringBuilder tempSb = new StringBuilder();
        StringBuilder ansSb = new StringBuilder();
        Map<String, Character> map = new HashMap<>();
        fillMap(map);
        // s의 각 문자를 순회
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // - flag가 false일 때
            if(!flag) {
                // - 숫자가 아니면
                if('0' > c || c > '9' ) {
                    // -- flag를 true로 전환
                    flag = true;
                    // -- temp StringBuilder에 담는다
                    tempSb.append(c);
                }
                // - 숫자이면
                else
                {
                    // -- 반환 StringBuilder에 담는다
                    ansSb.append(c);
                }
            }
            // flag가 true일 때
            else {
                // - 숫자가 아니면
                if('0' > c || c > '9' ) {
                    // -- temp StringBuilder에 담는다
                    tempSb.append(c);
                    // -- 현재 tempSb가 유효하면
                    if(map.containsKey(tempSb.toString())) {
                        // --- tempSb의 값을 -> ansSb에 추가
                        ansSb.append(map.get(tempSb.toString()));
                        tempSb.setLength(0);
                        // --- flag는 false
                        flag = false;
                    }
                }
                // - 숫자이면
                else
                {
                    // -- 반환 StringBuilder에 담는다
                    ansSb.append(c);
                }
            }

            System.out.println(ansSb);
        }
        // 순회 끝
        // 반환 StringBuilder 내용을 answer에 넣기
        answer = Integer.parseInt(ansSb.toString());
        return answer;
    }

    private void fillMap(Map<String, Character> map) {
        map.put("zero", '0');
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
    }
}
