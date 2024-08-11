package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=1; i<=n; i++) {
            // a,b 각각 카운팅 배열을 만들어 저장
            int[] a_count = new int[5];
            int[] b_count = new int[5];

            st = new StringTokenizer(br.readLine());
            int a_len = Integer.parseInt(st.nextToken());
            for(int j=0; j<a_len; j++)
                a_count[Integer.parseInt(st.nextToken())]++;

            st = new StringTokenizer(br.readLine());
            int b_len = Integer.parseInt(st.nextToken());
            for(int j=0; j<b_len; j++)
                b_count[Integer.parseInt(st.nextToken())]++;
            // 이번 라운드의 승자를 출력
            System.out.println(getWinner(a_count, b_count));
        }
    }

    private static String getWinner(int[] a_count, int[] b_count) {
        for(int i=4; i>0; i--) {
            if(a_count[i] != b_count[i])
                return a_count[i] > b_count[i] ? "A" : "B";
        }
        return "D";
    }
}
