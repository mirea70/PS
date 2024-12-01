package com.exercise.ps.Programmers.kakao;

import java.util.*;

public class WinterIntership2019_1 {
    public int[] solution(String s) {
        int[] answer = {};
        boolean numFlag = false;
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = null;
        List<Set<Integer>> list = new ArrayList<>();
        // s를 순회 1번부터 n-1번까지
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            // {라면
            if (c == '{') {
                set = new HashSet<>();
            }
            // - 숫자라면
            else if (c >= '0' && c <= '9') {
                numFlag = true;
                sb.append(c);
            }
            // , 라면
            else if(c == ',') {
                // numFlag가 true
                if(numFlag) {
                    // numflag = false
                    numFlag = false;
                    // sb에 있는 놈을 set에 담음
                    set.add(Integer.parseInt(sb.toString()));
                    // sb 초기화
                    sb.setLength(0);
                }
            }
            // - }를 만나면
            else if (c == '}') {
                // numFlag가 true
                if(numFlag) {
                    // numflag = false
                    numFlag = false;
                    // sb에 있는 놈을 set에 담음
                    set.add(Integer.parseInt(sb.toString()));
                    // sb 초기화
                    sb.setLength(0);
                }
                // -- set을 list에 추가
                list.add(set);
            }
        }
        // s 순회 끝
        for(Set<Integer> sets : list) {
            System.out.println(sets.toString());
        }

        // chkSet 생성
        Set<Integer> chkset = new HashSet<>();
        // list를 set길이 오름차순 정렬
        list.sort((o1, o2) -> o1.size() - o2.size());
        // 리스트 길이만큼 answer 생성
        int len = list.size();
        answer = new int[len];
        // 리스트 순회
        for (int i = 0; i < len; i++) {
            // - 해당 리스트의 set을 순회
            for (int a : list.get(i)) {
                // -- chkSet에 저장되어 있지 않은 수를 찾는다.
                if (!chkset.contains(a)) {
                    // -- 찾은 그 수를 chkSet에 넣고,
                    chkset.add(a);
                    // -- answer의 현재인덱스에도 담는다
                    answer[i] = a;
                    break;
                }
            }
            // - set 순회 끝
        }
        // 리스트 순회 끝
        return answer;
    }
}
