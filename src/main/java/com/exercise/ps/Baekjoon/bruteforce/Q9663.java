package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q9663 {

    private static int N;
    private static int count = 0;
    // 열체크
    private static boolean[] colChk;
    // 왼아래 -> 오른위 대각
    private static boolean[] diag1;
    // 왼위 -> 오른아래 대각
    private static boolean[] diag2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 체크배열 초기화
        colChk = new boolean[N];
        diag1 = new boolean[N*2-1];
        diag2 = new boolean[N*2-1];
        // 퀸을 놓는 dfs 실행
        dfs(0);
        // 경우의 수 출력
        System.out.print(count);
    }

    // 퀸 놓기 dfs
    private static void dfs(int row) {
        if(row == N) {
            count++;
            return;
        }

        for(int col=0; col<N; col++) {
            if(colChk[col] || diag1[row + col] || diag2[row-col +N-1]) continue;

            colChk[col] = diag1[row+col] = diag2[row-col +N-1] = true;
            dfs(row+1);
            colChk[col] = diag1[row+col] = diag2[row-col +N-1] = false;
        }
    }
}
