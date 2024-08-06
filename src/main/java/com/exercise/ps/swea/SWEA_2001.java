package main.java.com.exercise.ps.swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[][] map = new int[n][n];
            // map 그리기
            for(int j=0; j<n; j++) {
                String[] line = sc.nextLine().split(" ");
                for(int k=0; k<n; k++) {
                    map[j] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
                }
            }
            int max = 0;
            // 0,0부터 m크기 파리채 때리기 시도
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    // 현재 col + m > n 또는 현재 row + m > n 이면 패스
                    if(j+m > n || k + m > n) continue;
                    int tmp = 0;
                    for(int r=j; r<j+m; r++) {
                        for(int c=k; c<k+m; c++) {
                            tmp+= map[r][c];
                        }
                    }
                    // 죽은 파리갯수 최댓값 갱신
                    max = Math.max(max, tmp);
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
}
