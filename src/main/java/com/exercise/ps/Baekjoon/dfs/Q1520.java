package main.java.com.exercise.ps.Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1520 {
	static int M;
	static int N;
	static int[] dy = new int[]{-1,1,0,0};
	static int[] dx = new int[]{0,0,-1,1};
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		dp = new int[M+1][N+1];
		// 맵 그리기
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		// 1,1 부터 dfs 돌고나서 값 출력
		System.out.println(dfs(1,1));
	}

	private static int dfs(int y, int x) {
		// 현재 위치가 M, N이면 cnt++, 리턴
		if(y == M && x == N) {
			return 1;
		}
		// 이미 왔던 곳을 다시 최초방문 시도하면 원래값 리턴
		if(dp[y][x] != -1) return dp[y][x];
		// 방문체크
		dp[y][x] = 0;
		// 상하좌우 이동 시도
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 벽, 방문 예외처리
			if(ny < 1 || ny > M) continue;
			if(nx < 1 || nx > N) continue;
			// 이동할 높이가 현재 높이보다 크거나 같으면 이동 X
			if(map[ny][nx] >= map[y][x]) continue;
			// dfs 다음껏 돌고나서 값 dp에 더하기
			dp[y][x] += dfs(ny,nx);
			// 상하좌우 이동 시도 끝
		}

		return dp[y][x];
	}
}
