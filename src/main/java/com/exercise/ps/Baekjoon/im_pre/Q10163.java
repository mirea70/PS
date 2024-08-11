package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1001, 1001 평면 공간 준비
        int[][] space = new int[1001][1001];
        // 색종이를 1번부터 그려나가는데, 해당하는 범위에 넘버링을 하여 그린다.
        // 즉 1번영역은 1번으로, 2번영역은 2번으로 -> 이렇게하면 덮어씌워질 것이다.
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int r=y; r< y+height; r++) {
                for(int c=x; c< x+width; c++) {
                    space[r][c] = i;
                }
            }
        }
        // 그리기 작업 끝
        int[] areas = new int[n+1];
        // 평면 공간을 순회하며 해당하는 번호일경우에만 면적 배열에다 카운팅을한다.
        for(int r=0; r<1001; r++) {
            for(int c=0; c<1001; c++) {
                int num = space[r][c];
                if(num != 0) {
                    areas[num]++;
                }
            }
        }
        // 면적 배열을 순회하며 면적을 출력한다.
        for(int i=1; i<=n; i++)
            System.out.println(areas[i]);
    }
}
