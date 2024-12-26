package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Basic73 {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        // delete_list를 set에 담는다
        Set<Integer> delete_set = new HashSet<>();
        for(int delete_num : delete_list)
            delete_set.add(delete_num);
        // 결과 리스트
        List<Integer> list = new ArrayList<>();
        // arr 순회
        for(int num : arr) {
            // delete_list에서 arr 존재하는지 체크
            // 존재하지 않으면 결과 리스트에 추가
            if(!delete_set.contains(num)) {
                list.add(num);
            }
        }
        // 순회 끝

        // 결과 리스트 배열로 반환
        return list.stream().mapToInt(i->i).toArray();
    }
}
