package main.java.com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14501 {

    static int max = 0;

    static int N = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> consults = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] consult = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            consults.add(consult);
        }

        // 상담 일자 순회 : 각 상담일을 첫 시작일로 하는 경우의 수 방문
        // N일 중 N일을 방문
        // 해당 조합은 총 일수 >= N일 때 탈출하며, 최대 이익 갱신
        updateMax(consults, new boolean[N], 0, 0);
        // 최대 이익 출력
        System.out.println(max);
    }

    private static void updateMax(List<int[]> consults, boolean[] visit, int now, int sum) {
        if(N <= now) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = now; i<consults.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                if(N  >= i + consults.get(i)[0]) {
                    updateMax(consults, visit, i + consults.get(i)[0], sum + consults.get(i)[1]);
                }
                else {
                    updateMax(consults, visit, i + consults.get(i)[0], sum);
                }
                visit[i] = false;
            }
        }
    }
}
