package com.exercise.ps.Programmers.kakao;

import java.util.Arrays;

public class Blind2018_1 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = new int[]{9,20,28,18,11};
        int[] arr2 = new int[]{30,1,21,17,28};
        System.out.print(Arrays.toString(solution(n,arr1,arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // arr1으로 1번지도 생성
        char[][] map1 = toMap(arr1);
        // arr2로 2번지도 생성
        char[][] map2 = toMap(arr2);
        // 지도 비교 -> 전체지도 생성
        char[][] map = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char val1 = map1[i][j];
                char val2 = map2[i][j];
                if(val1 == '1' || val2 == '1')
                    map[i][j] = '#';
                else if(val1 == '0' && val2 == '0')
                    map[i][j] = ' ';
            }
        }
        StringBuilder sb = new StringBuilder();
        // 전체지도 순회
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // answer 그리기
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        // 순회 끝
        return answer;
    }

    // 수 배열을 받으면, 그에 맞게 지도를 반환하는 함수
    private static char[][] toMap(int[] arr) {
        int len = arr.length;
        char[][] map = new char[len][len];

        for(int i=0; i<len; i++) {
            String s = String.format("%0" + len + "d", Long.parseLong(Integer.toString(arr[i], 2)));
            map[i] = s.toCharArray();
            System.out.println(Arrays.toString(map[i]));
        }
        return map;
    }
}
