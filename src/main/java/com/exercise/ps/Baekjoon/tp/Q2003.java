package main.java.com.exercise.ps.Baekjoon.tp;

import java.util.*;
import java.io.*;

public class Q2003 {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		// 포인터 s, e를 둔다
		int s = 0;
		int e = 0;
		int sum = 0;
		int cnt = 0;
		// 배열 순회
		while(true) {
			if(sum>=M) {
				sum -= arr[s++];
			}
			else if(e == N) break;
			else {
				sum += arr[e++];
			}
			if(sum == M) cnt++;
		}
		// 배열 끝
		// 카운트 출력
		System.out.println(cnt);
	}
}
