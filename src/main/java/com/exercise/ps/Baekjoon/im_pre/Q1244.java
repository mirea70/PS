package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            switches[i] = Integer.parseInt(st.nextToken());

        int student_len = Integer.parseInt(br.readLine());
        for(int i=0; i<student_len; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            change_switch(switches, gender, num);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(switches[i]).append(" ");
            if(i != 0 && (i+1) % 20 == 0) {
                sb.setLength(sb.length()-1);
                sb.append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    private static void change_switch(int[] switches, int gender, int num) {
        switch (gender) {
            case 1: {
                for(int i=0; i<switches.length; i++) {
                    if((i+1) % num == 0) switches[i] = switches[i] == 1 ? 0 : 1;
                }
            }
            break;
            case 2: {
                int left = num-1;
                int right = num-1;
                // 스위치 상태 바꿀 구간 찾기
                while(left >= 0 && right <switches.length) {
                    int n_left = left-1;
                    int n_right = right+1;

                    if(n_left < 0 || n_right >= switches.length) break;
                    if(switches[n_left] != switches[n_right]) break;

                    left = n_left;
                    right = n_right;
                }
                // 스위치 상태 바꾸기
                for(int i=left; i<=right; i++) {
                    switches[i] = switches[i] == 1 ? 0 : 1;
                }
            }
            break;
        }
//        System.out.println(Arrays.toString(switches));
    }
}
