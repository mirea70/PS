package main.java.com.exercise.ps.swea;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_2005 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            // n+1 크기의 이차원 배열 생성
            int[][] result = new int[n+1][];
            for(int j=1; j<=n; j++) {
                result[j] = new int[j+1];
            }
            // n번 반복하며 삼각형을 만든다
            for(int r=1; r<=n; r++) {
                for(int c=1; c<=r; c++) {
                    // 이전 row에서 col기준 자신 및 자신-1 인덱스가 존재한다면
                    if(r>2 && c-1 >=1 && c < r) {
                        // 그둘을 더한값을 넣고
                        result[r][c] = result[r-1][c-1] + result[r-1][c];
                    }
                    else {
                        // 존재하지않는다면 1을 넣는다
                        result[r][c] = 1;
                    }
                }
            }
            System.out.println("#" + t);
            StringBuilder sb = new StringBuilder();
            for(int r=1; r<=n; r++) {
                for(int c=1; c<=r; c++) {
                    sb.append(result[r][c]).append(" ");
                }
                sb.setLength(sb.length()-1);
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
    }
}
