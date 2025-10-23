package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MR3655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 기다리는 인원 배열에 저장
            Character[] arr = new Character[N];
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                arr[j] = line.charAt(j);
            }

//            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            // 각 타입별로, 마지막 인덱스 저장, 이 때 타입별 인원수도 함께 저장
            Map<Character, Integer> orgLastIdxMap = new HashMap<>();
            Map<Character, Integer> afterLastIdxMap = new HashMap<>();
            Map<Character, Integer> cntMap = new HashMap<>();
            for(int j=0; j<N; j++) {
                char type = arr[j];
                orgLastIdxMap.put(type, j);
                cntMap.put(type, cntMap.getOrDefault(type, 0) + 1);
            }
            // 인원 배열을 마지막 인덱스 기준 오름차순 정렬
            Arrays.sort(arr, (o1,o2) -> orgLastIdxMap.get(o1) - orgLastIdxMap.get(o2));
            // 정렬 후, 다시 순회하며 마지막 인덱스를 afterMap에 저장
            for(int j=0; j<N; j++) {
                char type = arr[j];
                afterLastIdxMap.put(type, j);
            }

            int saved = 0;
            // map의 타입 순회(key)
            for(char type : orgLastIdxMap.keySet()) {
                // 각 타입별 정렬 후, 전의 마지막 인덱스 차이를 기준으로 절약시간 계산
                // - (기존 마지막 인덱스 - 정렬 후 마지막 인덱스) * 5 * (해당 그룹의 인원수)
                saved += (orgLastIdxMap.get(type) - afterLastIdxMap.get(type)) * 5 * cntMap.get(type);
            }

            System.out.println(saved);
        }
    }
}
