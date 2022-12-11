package com.exercise.ps.Programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class hash_1 {
    public static void main(String[] args) {

    }
}

class hash_1_Solution {
    public String solution(String[] participant, String[] completion) {
        // 완전탐색할 경우, 약 10^10번 순회해야하므로 시간초과
        // 참여자 배열을 한번 순회하며 hashmap에 넣는다(1을 넣고, 동명이인 있을 수 있으므로 만약 있으면 그값을 가져와 + 1한다)
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }
        // 완주자 배열을 순회하며 hashmap에서 그 키값의 value -1 한다.
        for(String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }
        // value가 0이 아닌 key값을 리턴한다.
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() != 0) answer = entry.getKey();
        }

        return answer;
    }
}