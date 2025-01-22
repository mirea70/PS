package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic100 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 100, 99, 98};

        System.out.print(solution(arr));
    }

    public static int solution(int[] arr) {
        int x = 0;
        // 연산 후, 배열의 결과를 저장하는 리스트
        List<int[]> list = new ArrayList<>();
        // 현재 배열을 리스트에 담음
        list.add(Arrays.copyOf(arr, arr.length));
        // 리스트 크기가 1이거나 리스트 마지막 배열과 그 전배열이 다를 동안 반복
        while(list.size() == 1 || !isSameArr(list.get(list.size()-2), list.get(list.size()-1))) {
            System.out.println(Arrays.toString(arr));
            // x++
            x++;
            // 연산한다
            for(int i=0; i<arr.length; i++) {
                if(arr[i] >= 50 && arr[i] % 2 ==0)
                    arr[i] /= 2;
                else if(arr[i] < 50 && arr[i] % 2 != 0)
                    arr[i] = arr[i]*2 + 1;
            }
            // 연산한 결과 리스트에 담음
            list.add(Arrays.copyOf(arr, arr.length));
        }
        // 반복 끝
        return x-1;
    }

    // 두 배열의 일치 여부 판별
    private static boolean isSameArr(int[] prev, int[] current) {
        for(int i=0; i<prev.length; i++) {
            if(prev[i] != current[i])
                return false;
        }

        return true;
    }
}
