package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 원본 배열 저장 (원래 자리)
        int[] arr = new int[n];
        for(int i=1;i<=n; i++) {
            arr[i-1] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        // 숫자 뽑는 반복문
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 목표 인덱스 지정
            // - 자신의 원래 위치 - num
            int target_idx = i - num;
            // 해당 인덱스로 리스트를 채운다
            list.add(target_idx, arr[i]);
        }
        // 반복 끝
        // 리스트 값 출력
        StringBuilder sb = new StringBuilder();
        for(int a : list)
            sb.append(a).append(" ");
        System.out.print(sb);
    }
}
