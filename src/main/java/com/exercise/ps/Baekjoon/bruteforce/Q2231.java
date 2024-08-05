package main.java.com.exercise.ps.Baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Q2231 {

	static int min = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1 ~ N을 순회
		for (int i=1; i<N; i++) {
			// 분해합을 구해서 N이 되는지 체크
			int result = isConstructor(i, N);
			if(result != -1) {
				// 되면 생성자 최솟값 갱신
				min = Math.min(min, result);
			}
		}
		// 생성자 최솟값 출력
		if(min == 1000000) min = 0;
		System.out.println(min);
	}

	private static int isConstructor(int source, int target) {
		// source를 String으로 교체
		String str = String.valueOf(source);
		// String을 자릿수 별로 분할하여 배열 생성
		String[] arr = str.split("");
		// 배열들의 합 + source 가 target과 일치하는지 확인
		int sum = Arrays.stream(arr).mapToInt(i -> Integer.parseInt(i)).sum();
		// 일치하면 해당 값, 아니면 -1 리턴
		return sum + source == target ? source : -1;
	}

}
