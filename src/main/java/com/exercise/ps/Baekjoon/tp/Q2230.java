package com.exercise.ps.Baekjoon.tp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 오름차순 정렬
        Arrays.sort(arr);
        // 최초 양 끝값으로 차이 갱신
        int INF = 2000000000;
        int s = 0;
        int e = 0;
        int min = INF;
        // 양 끝부터 중앙까지 차례로 줄여온다. 차이가 M 미만이 되면 종료
        while(s < N) {
            // e를 M 이상일 때까지 키우기
            while(e < N && arr[e] - arr[s] < M) {
                e++;
            }
            if(e == N) break; // 더이상 M 이상인 값 찾기 불가능
            // 차이값 갱신
            min = Math.min(min, arr[e] - arr[s]);
            // s 늘려서 더 작은 차이값 체크
            s++;
        }
        // 반복문이 끝나고 차이값을 출력
        System.out.print(min);
    }
}
