package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q1759 {
    private static List<String> try_list = new ArrayList<>();
    private static String validVowel = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[] arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        // 배열을 미리 오름차순 정렬 (정렬되지 않은 나열은 의미없으므로)
        Arrays.sort(arr);
        // C개 중 L개만큼 뽑는 순열
        combination(arr, new boolean[C], "", 0, 0, L);
        // try_list 출력
        for (String s : try_list) {
            System.out.println(s);
        }
    }

    private static void combination(char[] arr, boolean[] visit, String current, int start, int depth, int r) {
        if(depth == r) {
            // 순열 뽑을 때마다 유효성 체크
            if(isValid(current)) {
                // 통과하면 리스트에 추가
                try_list.add(current);
            }
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(arr, visit, current + arr[i], i+1, depth+1, r);
                visit[i] = false;
            }
        }
    }

    private static boolean isValid(String str) {
        int vowelCnt = 0;
        int consonantCnt = 0;
        char first_c = str.charAt(0);

        if(isValidVowel(first_c)) {
            vowelCnt++;
        }
        else {
            consonantCnt++;
        }

        // str 순회
        for(int i=1; i<str.length(); i++) {
            char c = str.charAt(i);
            if(isValidVowel(c)) {
                vowelCnt++;
            }
            else {
                consonantCnt++;
            }

        }
        // 순회 끝
        // 모음 1개 미만이거나, 자음 2개 미만이면 false
        // 모두 패스시 True
        return vowelCnt >= 1 && consonantCnt >= 2;
    }

    private static boolean isValidVowel(char val) {
        for(char c : validVowel.toCharArray()) {
            if(c == val) return true;
        }
        return false;
    }
}
