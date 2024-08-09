package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 성별/학년 을 가지는 이차원 배열 생성
		int n = Integer.parseInt(st.nextToken());
		double k = Double.parseDouble(st.nextToken());
		
		int[][] students = new int[2][7];
		// 입력을 받으면서 이차원 배열의 값을 채운다
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[gender][grade]++;
		}
		// 입력 끝
		int total = 0;
		// 이차원 배열을 순회하면서, 각 값을 k로 나눈 몫(올림)을 누적
		for(int gender=0; gender<2; gender++) {
			for(int grade=1; grade<=6; grade++) {
				total += Math.ceil(students[gender][grade] / k);
			}
		}
		// 누적값 출력
		System.out.print(total);
	}
}
