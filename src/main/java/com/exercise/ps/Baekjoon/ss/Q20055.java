package com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q20055 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * N  + 1];
        for(int i = 1; i<=2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        // 로봇 위치 boolean[]
        boolean[] is_robot = new boolean[N+1];
        // while문 돈다
        int cnt = 0;

        loop:
        while(true) {
            // 단계 카운트
            cnt++;
            // 벨트 회전 -> 내리는 위치이고, 로봇이 있었다면 내리기
            int temp = belt[2*N];
            System.arraycopy(belt, 1, belt, 2, 2*N - 1);
            belt[1] = temp;
            System.arraycopy(is_robot,1, is_robot, 2, N-1);
            is_robot[1] = false;
            if(is_robot[N]) is_robot[N] = false;
            // 로봇 이동 시도 -> 이동하면 내구도 깎고, boolean 바꾸기
            for(int i=N-1; i>1; i--) {
                if(is_robot[i] && !is_robot[i+1] && belt[i+1] >= 1) {
                    is_robot[i] = false;
                    is_robot[i+1] = true;
                    belt[i+1]--;
                }
            }
            // 내리는 위치이면 내리기
            if(is_robot[N]) is_robot[N] = false;
            // 올리기 시도 -> 올리면 내구도 깎기
            if(belt[1] >= 1) {
                is_robot[1] = true;
                belt[1]--;
            }
            // 내구도 0칸인 개수 >= K 이면 break;
            int t = 0;
            for(int i =1; i<=2*N; i++) {
                if(belt[i] <=0) t++;
                if(t>= K) break loop;
            }
        }
        // 반복 종료
        // 단계 카운트 출력
        System.out.println(cnt);
    }
}
