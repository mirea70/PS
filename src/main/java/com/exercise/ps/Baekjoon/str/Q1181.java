package com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // set에 담는다
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        // set을 list로 변환
        List<String> list = new ArrayList<>(set);
        // list를 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else return o1.length() - o2.length();
            }
        });
        // 리스트 문자들 출력
        for(String s : list) System.out.println(s);
    }
}
