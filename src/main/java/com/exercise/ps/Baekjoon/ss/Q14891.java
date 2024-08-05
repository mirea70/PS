package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q14891 {

    static List<Gear> gears = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 더미 기어
        gears.add(new Gear(new int[0]));
        for(int i=1; i<=4; i++) {
            int[] status_arr = Arrays.stream(br.readLine().split("")).mapToInt(s -> Integer.parseInt(s)).toArray();
            gears.add(new Gear(status_arr));
        }

        int K = Integer.parseInt(br.readLine());
        // 명령 반복
        StringTokenizer st;
        for (int i = 0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            // 명령에 따라 톱니바퀴 회전시킨다 (dfs)
            dfs(gears, index, dir, new boolean[5]);
        }
        // 명령 반복 종료
        // 톱니바퀴 점수 출력
        int score = 0;
        for(int i=1; i<=4; i++) {
           if(gears.get(i).status[0] == 1) {
               int a = 0;
               switch (i) {
                   case 1: a = 1;
                   break;
                   case 2: a = 2;
                       break;
                   case 3: a = 4;
                       break;
                   case 4: a = 8;
                       break;
               }
               score += a;
           }
        }
        System.out.println(score);
    }

    private static void dfs(List<Gear> gears, int index, int dir, boolean[] visit) {
        // 현재 index < 1 or index > 4이면 탈출
        if(index < 1 || index > 4) return;
        visit[index] = true;
        // 좌우 먼저 체크
        if(index -1 >= 1 && !visit[index-1] && gears.get(index).status[6] != gears.get(index-1).status[2])
            dfs(gears, index -1, -dir, visit);
        if(index + 1 <= 4 && !visit[index+1] && gears.get(index).status[2] != gears.get(index+1).status[6])
            dfs(gears, index + 1, -dir,visit);
        // 기어 회전
        gears.get(index).rotate(dir);
    }

    private static class Gear {

        int[] status;

        public void rotate(int dir) {
            int[] copy_status = status.clone();
            if(dir == 1) {
                status[0] = copy_status[7];
                for(int i=1; i<8; i++) {
                    status[i] = copy_status[i-1];
                }
            }
            else {
                status[7] = copy_status[0];
                for(int i=0; i<7; i++) {
                    status[i] = copy_status[i+1];
                }
            }
        }

        public Gear(int[] status) {
            this.status = status;
        }
    }
}
