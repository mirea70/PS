package com.exercise.ps.Baekjoon.bs;

import java.util.*;
import java.io.*;

public class Q1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a_arr = new int[N];
		for(int i=0; i<a_arr.length; i++) {
			a_arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] m_arr = new int[M];
		for(int i=0; i<m_arr.length; i++) {
			m_arr[i] = Integer.parseInt(st.nextToken());
		}
		// 배열 정렬
		Arrays.sort(a_arr);
		// A 배열을 이분 탐색
		for(int i=0; i<m_arr.length; i++) {
			// 서치결과 출력
			System.out.println(binarySearch(a_arr, m_arr[i]));
		}
	}

	private static int binarySearch(int[] arr, int key) {
		int s = 0;
		int e = arr.length - 1;

		while(s <= e) {
			int mid = (s + e) / 2;
			if(arr[mid] > key) e = mid - 1;
			else if(arr[mid] < key) s = mid + 1;
			else return 1;
		}

		return 0;
	}

}
