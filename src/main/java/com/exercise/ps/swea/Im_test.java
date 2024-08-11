package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Im_test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			// map 순회하며 폭발 시도 -> 최대값 갱신
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int val = bomb(p, map, n, i, j);
					if(val > max) max = val;
				}
			}
			System.out.printf("#%d %d%n", t, max);
		}
	}
	
	private static int bomb(int p, int[][] map, int n, int y, int x) {
		int sum = 0;
		
		
		if(p == 0) {
			sum += map[y][x];
		}
		else {
			int sum1 = map[y][x];
			int sum2 = map[y][x];
			// 상하좌우
			int[] dy1 = {-1,1,0,0};
			int[] dx1 = {0,0,-1,1};
			// 대각선들 왼 위, 오른 위, 왼 아래, 오른 아래
			int[] dy2 = {-1,-1,1,1};
			int[] dx2 = {-1,1,-1,1};
			
			// i는 이동할 방향
			for(int i=0; i<4; i++) {
				// 벽에 부딫히거나 p번할 때까지 해당 방향으로 이동
				int ny1 = y;
				int nx1 = x;
				int ny2 = y;
				int nx2 = x;
				for(int j=0; j<p; j++) {
					ny1 += dy1[i];
					nx1 += dx1[i];
					if(ny1 >= n || ny1 < 0 || nx1 >= n || nx1 < 0) continue;
					sum1 += map[ny1][nx1];
					
					ny2 += dy2[i];
					nx2 += dx2[i];
					if(ny2 >= n || ny2 < 0 || nx2 >= n || nx2 < 0) continue;
					sum2 += map[ny2][nx2];
				}
				
			}
			
			sum = Math.max(sum1, sum2);
		}
		
		return sum;
	}
}
