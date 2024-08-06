package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q14499 {

	static int[][] map;
	static int N,M,sy,sx,K;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 맵 그리기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] commands = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}
		Dice dice = new Dice(sy, sx);
		// 명령에 따라 주사위 이동
		for(int command : commands) dice.moveAndRotate(command);
	}

	private static class Dice {
		// 천장 위옆 오른옆 왼옆 아래옆 밑에옆
		int[] shape;
		// 위치
		int y;
		int x;
		// 이동 명령에 따라 주사위 회전 및 이동
		public void moveAndRotate(int command) {

			int ny = 0;
			int nx = 0;

			switch(command) {
				case 1: {
					ny = y;
					nx = x + 1;
				}
				break;
				case 2: {
					ny = y;
					nx = x - 1;
				}
				break;
				case 3: {
					ny = y - 1;
					nx = x;
				}
				break;
				case 4: {
					ny = y + 1;
					nx = x;
				}
				break;
			}

			if(ny < 0 || ny >= N || nx < 0 || nx >= M) return;

			int[] temp = shape.clone();
			switch(command) {
				case 1: {
					shape[2] = temp[0];
					shape[0] = temp[3];
					shape[3] = temp[5];
					shape[5] = temp[2];
				}
				break;
				case 2: {
					shape[2] = temp[5];
					shape[0] = temp[2];
					shape[3] = temp[0];
					shape[5] = temp[3];
				}
				break;
				case 3: {
					shape[1] = temp[0];
					shape[0] = temp[4];
					shape[4] = temp[5];
					shape[5] = temp[1];
				}
				break;
				case 4: {
					shape[1] = temp[5];
					shape[0] = temp[1];
					shape[4] = temp[0];
					shape[5] = temp[4];

				}
				break;
			}

			if(map[ny][nx] == 0) map[ny][nx] = shape[5];
			else {
				shape[5] = map[ny][nx];
				map[ny][nx] = 0;
			}

			y = ny;
			x = nx;

			System.out.println(shape[0]);
		}

		public Dice(int sy, int sx) {
			y = sy;
			x = sx;

			shape = new int[6];
		}
	}

}
