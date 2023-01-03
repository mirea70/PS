package com.exercise.ps.Programmers.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sort_3 {
    public static void main(String[] args) {

    }
}
class sort_3_Solution {
    public int solution(int[] citations) {
        int max = 0;
        // citations을 박싱하여 내림차순 정렬한다
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        // citations을 순회하며
        for(int i=0;i<arr.length;i++){
            // 0번 째 ~ 현재 인덱스까지의 길이가 현재 값 이상이면
            if(i+1 >= arr[i]) {
                // 해당 값을 max에 넣고
                max = i + 1 > arr[i] ? i : arr[i];
                // 반복문 종료
                break;
            }
        }
        if(arr[0] != 0 && max == 0) max = arr.length;
        return max;
    }
    // 3 40 45 60 34 9 -> 60 45 40 34 9 3
}
