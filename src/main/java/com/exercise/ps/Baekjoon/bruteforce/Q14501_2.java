package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14501_2 {
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, 상담 일정표 리스트에 저장
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        list.add(new int[2]); // dummy

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 각 일자별 시작일자로 상담 시작
        for(int day=1; day<=N; day++) {
            counsel(list, day, 0, N);
        }
        // 최대 이익 출력
        System.out.print(max);
    }

    private static void counsel(List<int[]> list, int day, int revenue, int N) {
        // 현재 날짜가 N 초과시 최대이익 갱신 후 리턴
        if(day > N) {
            max = Math.max(max, revenue);
            return;
        }
        // 리스트에서 현재 날짜의 걸리는 시간, 이익 추출
        int T = list.get(day)[0];
        int R = list.get(day)[1];
        // 현재 날짜 + 걸리는 시간 ~ N까지 재귀
        for(int nDay = day+T; nDay<=N+1; nDay++)
            counsel(list, nDay, revenue+R, N);
    }
}
