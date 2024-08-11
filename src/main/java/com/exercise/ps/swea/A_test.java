package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A_test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 나무 배열
			int[] trees = new int[n];
			boolean[] finished = new boolean[n];
			for(int i=0; i<n; i++)
				trees[i] = Integer.parseInt(st.nextToken());
			// 4
			// 2 3 10 5
			// 나무 정렬
			Arrays.sort(trees);
			// 나무의 최대값 구하기
			int max = trees[n-1];
			// 하루에 한나무 물 줄수 있음
			// 91011121314  35678     124
			// 각각의 나무가 최대값을 맞추기위한 최소값을 각각 구하면 됨
			// 날짜를 순회
			int day = 0;
			// max값을 모두 맞출때까지 반복
			// 초기 finish_idx 찾기
			for(int i= n-1; i>=0; i--) {
				if(trees[i] == max) finished[i] = true;
			}
			
			while(!allFinished(finished)) {
				day++;
//				System.out.println(Arrays.toString(trees));
			// 배열 역순 순회
				for(int i=n-2; i>=0; i--) {
					int val = trees[i];
			// 이미 최대값이거나 현재값이 최대값 -2이면서 현재 날짜가 홀수라면 다음 나무로 넘기기		
					if(!((finished[i] || val == max-2 && day % 2 != 0) || (val == max-1 && day % 2 == 0))) {
						// 아니라면
						// 물 주기
						val += day % 2 != 0 ? 1 : 2;
						trees[i] = val;
						if(val == max) finished[i] = true;
						break;
					}
				}
			}
			// 날짜 순회 끝
			// 날짜 수 출력
			System.out.printf("#%d %d%n", t, day);
		}
	}
	
	private static boolean allFinished(boolean[] finished) {
		for(int i=0; i<finished.length; i++) {
			if(!finished[i]) return false;
		}
		return true;
	}
}
