package main.java.com.exercise.ps.Baekjoon.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];
		for(int i=1; i<=n; i++) {
			students[i-1] = i;
		}
		
		System.out.println(Arrays.toString(students));
		
		int[] result = new int[n];
		
		// 번호 뽑고 뽑는 것에 따라 위치 변경
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num != 0) {
				int target_idx = i - num;
				int target_value = students[target_idx];
				int src_value = students[i];
				
				for(int j= n-1; j>target_idx+1; j--) {
					students[j] = students[j-1];
				}
				students[target_idx] = src_value;
			}
		}
		
		for(int a : students)
			System.out.print(a + " ");
	}
}
