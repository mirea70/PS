package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic94 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        // 값이 2인 인덱스를 담는 리스트
        List<Integer> list = new ArrayList<>();
        // arr 순회
        for(int i=0; i<arr.length; i++) {
            // 리스트에 2인 인덱스 담기
            if(arr[i] == 2)
                list.add(i);
        }
        // 순회 끝
        // 리스트 크기별로 분기
        switch (list.size()) {
            // 0이면 -1 담아 리턴
            case 0: return new int[]{-1};
            // 1이면 2담아 리턴
            case 1: return new int[]{2};
            // 1보다 크면 리스트에 담긴 첫 인덱스 ~ 마지막 인덱스까지 포함하여 복사한 배열 리턴
            default: {
                return Arrays.copyOfRange(arr, list.get(0), list.get(list.size()-1)+1);
            }
        }
    }
}
