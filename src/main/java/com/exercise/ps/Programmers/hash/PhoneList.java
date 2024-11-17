package com.exercise.ps.Programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // phone_book을 오름차순 정렬
        Arrays.sort(phone_book);
        // 접두어 식별 해시 map
        Map<String, Boolean> preMap = new HashMap<>();
        // phone_book 순회
        for(String phone : phone_book) {
            // - 자신의 문자들을 1자리부터 끝까지 붙여나가며 map에 존재하는지 확인
            for(int i=0; i<phone.length(); i++) {
                // - 존재한다면 false 후 break
                if(preMap.containsKey(phone.substring(0,i+1))) {
                    answer = false;
                    break;
                }
            }
            // - 확인 끝
            // - map에 자신을 담는다.
            preMap.put(phone, true);
        }
        return answer;
    }
}
