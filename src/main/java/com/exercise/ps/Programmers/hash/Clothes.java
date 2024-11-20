package com.exercise.ps.Programmers.hash;

import java.util.*;

public class Clothes {
    int answer = 0;

    public int solution(String[][] clothes) {

        // 의상의 종류 넘버링을 저장하는 map
        Map<Integer,String> clothNumber = new HashMap<>();
        // 의상의 number 별로 clothes를 저장하는 List
        List<Set<String>> clothesList = new ArrayList<>();
        // map과 리스트 채우기
        for(int i=0; i<clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];

            if(!clothNumber.containsValue(type)) {
                int num = clothesList.size();
                clothNumber.put(num, type);

                Set<String> set = new HashSet<>();
                set.add(name);
                clothesList.add(set);
            }
            else {
                Integer num = null;
                for(Map.Entry<Integer, String> entry : clothNumber.entrySet()) {
                    if(entry.getValue().equals(type)) {
                        num = entry.getKey();
                        break;
                    }
                }

                Set<String> set = clothesList.get(num);
                set.add(name);
            }
        }
        // map의 key의 개수가 총 depth의 크기
        int len = clothNumber.keySet().size();
        // 조합의 수 세기
        count(clothesList, 0, len, false);
        return answer;
    }
    // 조합의 수를 세는 함수
    private void count(List<Set<String>> clothesList, int depth, int len, boolean isPick) {
        // depth가 len과 같을경우
        if(depth == len) {
            // 하나라도 골랐었으면 answer 갱신
            if(isPick) answer++;
            // 리턴
            return;
        }
        // 입지 않음
        count(clothesList, depth+1, len, isPick);
        // set 순회
        for(String clothes : clothesList.get(depth)) {
            // - 해당 옷을 입고 다음으로 넘어감
            count(clothesList, depth+1, len, true);
        }
    }
}
