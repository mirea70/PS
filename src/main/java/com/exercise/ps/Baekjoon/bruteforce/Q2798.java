package main.java.com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798 {

    static int sum = 0;

    static int M;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 주어진 수를 모두 순회하며 3개의 조합을 만든다.
        // 조합의 합이 M과 더 가까우면 그 합을 갱신한다.
        updateSum(arr, new boolean[N], new int[3], 0, 0, 3);
        System.out.println(sum);
    }

    private static void updateSum(int[] arr, boolean[] visit,int[] output , int start, int depth, int r) {

        if(depth == r) {
                int cur_sum = 0;
                for (int a : output) {
                    cur_sum += a;
                }
            if(cur_sum <= M) {
                boolean isRight = Math.abs(M - cur_sum) - Math.abs(M - sum) < 0;
                if(isRight) sum = cur_sum;
            }
        }

        for(int i = start; i < arr.length; i++) {
            if(!visit[i] && depth < 3) {
                visit[i] = true;
                output[depth] = arr[i];
                updateSum(arr, visit, output, i + 1, depth +1, 3);
                visit[i] = false;
            }
        }
    }
}
