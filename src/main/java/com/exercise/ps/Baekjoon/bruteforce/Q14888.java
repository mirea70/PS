package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q14888 {

	static int[] nums;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] toolCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
		List<String> tools = new ArrayList<>();
		while(!(toolCnt[0] ==0 && toolCnt[1] == 0 && toolCnt[2] ==0 && toolCnt[3] == 0)) {
			for(int i=0; i<toolCnt.length; i++ ) {
				String str = null;
				if(toolCnt[i] != 0) {
					switch (i) {
						case 0: str = "+";
						break;
						case 1: str = "-";
						break;
						case 2: str = "*";
						break;
						case 3: str = "%";
						break;
					}
					toolCnt[i]--;
				}
				if(str != null)
					tools.add(str);
			}
		}
		// 연산자를 나열하는 경우의 수 - 순열 방문
		String[] output = new String[tools.size()];
		perm(tools, output, new boolean[tools.size()], 0, tools.size());
		// 최댓값, 최솟값 출력
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(List<String> tools, String[] output, boolean[] visit, int depth, int r) {

		if(depth == r) {
			// 나열이 끝날 때, 해당 수를 계산한다.
			long result = nums[0];
			for(int i = 0; i<output.length; i++) {
				String tool = output[i];
				switch (tool) {
					case "+": result += nums[i + 1];
					break;
					case "-": result -= nums[i + 1];
					break;
					case "*": result *= nums[i + 1];
					break;
					case "%": {
						if(result > 0) {
							result = result/nums[i + 1];
						}
						else if(result == 0) {
						}
						else {
							result = -((-result)/nums[i + 1]);
						}
					}
					break;
				}
			}
			// 최댓값, 최솟값 갱신
			max = Math.max(max, result);
			min = Math.min(min, result);
		}

		for(int i=0; i<tools.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				output[depth] = tools.get(i);
				perm(tools, output, visit, depth + 1, r);
				visit[i] = false;
			}
		}
	}

}
