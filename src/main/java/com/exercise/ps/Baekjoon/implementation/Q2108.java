package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            double num = Double.parseDouble(br.readLine());
            int numm = (int) num;
            sum += num;
            list.add(numm);
            map.put(numm, map.getOrDefault(numm, 0)+1);
        }
        list.sort((o1,o2) -> o1-o2);
        // map 최빈값 내림차순 정렬
        List<Map.Entry<Integer,Integer>> entries =
                map.entrySet().stream()
                        .sorted((o1,o2) -> o2.getValue() - o1.getValue())
                        .collect(Collectors.toList());
        // 최빈값 해당 값들만 따로 리스트에 보관
        List<Integer> maxOften = new ArrayList<>();
        int max = entries.get(0).getValue();
        for(Map.Entry<Integer,Integer> m : entries) {
            if(m.getValue() == max) maxOften.add(m.getKey());
            if(m.getValue() < max) break;
        }
        // 리스트 키 기준 오름차순 정렬
        maxOften.sort((o1,o2) -> o1-o2);
        // 1번 인덱스 값 출력
        int oftenValue = maxOften.size() > 1 ? maxOften.get(1) : maxOften.get(0);
        double average = sum / n;
        String averagee = String.format("%.0f", average);
        int middle = list.get(list.size()/2);
        int dif = list.get(list.size()-1) - list.get(0);

        System.out.println(averagee.equals("-0") ? "0" : averagee);
        System.out.println(middle);
        System.out.println(oftenValue);
        System.out.println(dif);
    }
}
