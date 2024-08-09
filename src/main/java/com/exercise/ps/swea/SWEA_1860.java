package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // 손님들의 시간을 오름차순의 우선순위 큐에 담는다.
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> times = new PriorityQueue<>();
            for(int i=0; i<n; i++)
                times.add(Integer.parseInt(st.nextToken()));
            // 붕어빵 수
            int bread_cnt = 0;
            // times가 있을동안 반복문
            int time;
            // 누적 손님 수
            int people = 0;
            // 정답
            String ans = "Possible";

            while(!times.isEmpty()) {
                // - 큐에서 하나 뺀다.
                // - 큐에서 하나를 뺐다는 것은 그만큼 시간이 흘렀다는 의미이다.
                time = times.poll();
                // - 흐른 시간만큼 붕어빵을 만드는데, 소비되었을만큼 빼준다.
                bread_cnt = (time / m) * k - ++people;
                // - 소비숫자가 더 클 경우, 빵이 부족하다는 의미이므로 불가능, 종료
                if(bread_cnt < 0) {
                    ans = "Impossible";
                    break;
                }
            }
            // 반복 끝
            // 정답 출력
            System.out.printf("#%d %s%n", t, ans);
        }
    }
}
