package main.java.com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		// 모두 고르게 w/k만큼 중량이 걸리므로
		// 최대중량을 가장 작게 버틸 수 있는 로프에 맞춰야만 해당 중량을 들어올릴 수 있다.
		// 배열 정렬
		Arrays.sort(arr);
		// 배열 순회하며 자신의 값 * n-인덱스 값을 최대값 배열에 저장 -> 자신을 포함했을 때 가질 수 있는 최대값
		int[] max_arr = new int[n];
		for(int i=0; i<n; i++) {
			max_arr[i] = arr[i] * (n-i);
		}
		// 최대값 배열의 최대값이 정답이다.
		int max = 0;
		for(int i=0; i<n; i++) {
			if(max_arr[i] > max) max = max_arr[i];
		}
		
		System.out.println(max);
	}
}
