package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			// 농장 그리기
			char[][] map = new char[n][n];
			StringTokenizer st;
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			// n의 중앙값
			int mid = n/2;
			// 행 값 구할 count
			int count = 0;
			// 중앙행의 0열 ~ 끝 순회
			// 누적값
			int total = 0;
			for(int i=0; i<n; i++) {
			// i열일 때 i <= mid이면 count + 1
				// 기존 값 누적
				total += (map[mid][i] - '0');
			// count만큼 상, 하의 값도 함께 누적한다.
				for(int r=mid-count; r<=mid+count; r++) {
					if(r == mid) continue;
					total += (map[r][i] - '0');
				}
				if(i<mid) count += 1;
				// 아니라면 count - 1
				else count -= 1;
			}
			// 순회 끝
			// 누적값 출력
			System.out.printf("#%d %d%n", t, total);
		}
	}
}
