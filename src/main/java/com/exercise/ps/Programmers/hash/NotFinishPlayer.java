package com.exercise.ps.Programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class NotFinishPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // participant에 등장하는 이름의 수와, completion에 등장하는 이름의 수가 일치해야한다.
        Map<String,Integer> map = new HashMap<>();
        // participant 순회 - 각 이름을 key로 등장횟수 map에 기록
        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        // completion 순회 - 각 이름을 key로 등장횟수 차감
        for(String s : completion) {
            map.put(s, map.get(s)-1);
        }
        // 만약 일치하지 않을경우 그 이름을 반환한다.
        // map 순회 : 등장횟수 0이 아닐경우 해당 이름 반환
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 1) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
