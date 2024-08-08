package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// 스도쿠 그리기
			int[][] map = new int[9][9];
			StringTokenizer st;
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 1;
			// 검수할 set들
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> colSet = new HashSet<>();
			Set<Integer> gatherSet = new HashSet<>();
			// 0~9까지 순회
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
			// 같은 행 검수
				if(rowSet.contains(map[i][j])) {
					ans = 0;
					break;
				}
				else rowSet.add(map[i][j]);
			// 같은 열 검수
				if(colSet.contains(map[j][i])) {
					ans = 0;
					break;
				}
				else colSet.add(map[j][i]);
			// 같은 조 검수
				// 조번호가 0,1,2일때 -> 3으로 나눴을 때 몫 0
				// r -> j/3, c -> j%3 + 3*(조번호 % 3)
				// 조번호가 3,4,5일때 -> 3으로 나눴을 때 몫 1
				// r -> j/3 + 3 * (조번호/3) c ->  j%3 + 3 * (조번호 % 3)
				// 조번호가 6,7,8일때 -> 3으로 나눴을 때 몫 2
				// r -> j/3 + 3 * (조번호/3) c -> j%3 + 3 * (조번호 % 3)
				int r = j/3 + 3*(i/3);
				int c = j%3 + 3*(i%3);
				if(gatherSet.contains(map[r][c])) {
					ans = 0;
					break;
				}
				else gatherSet.add(map[r][c]);
				}
				// 검수 Set들 초기화
				rowSet.clear();
				colSet.clear();
				gatherSet.clear();
			}
			// 순회 끝
			// ans 출력
			System.out.printf("#%d %d%n", t, ans);
		}
	}
}
