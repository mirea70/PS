package com.exercise.ps.Baekjoon.bruteforce;

import java.util.HashMap;
import java.util.Scanner;

public class Q14501 {

	public static void main(String[] args) {
		Solution_Qu14501 ss = new Solution_Qu14501();
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		HashMap<Integer, int[]> consults = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String aa = sc.nextLine();
			String[] strArr = sc.nextLine().split("\\s");
			int[] intArr = {Integer.parseInt(strArr[0]), Integer.parseInt(strArr[0])};
			consults.put(i, intArr);
		}
		int maxRevenue = ss.maxRevenue(consults, N);
		System.out.println(maxRevenue);
	}

}

class Solution_Qu14501 {

	int maxRevenue = 0;
	public int maxRevenue(HashMap<Integer, int[]> consults, int N) {
		// 가능한 조합을 모두 방문 및 이익 최대값 갱신
		recursive(1, 1, new HashMap<Integer, int[]>(), consults, N);
		// maxRevenue 리턴
		return maxRevenue;
	}

	private void recursive(int now, int limit, HashMap<Integer, int[]> com, HashMap<Integer, int[]> others, int N) {
		// 현재 조합의 이익 합으로 최댓값 갱신한다.
		int sum = com.values().stream().map(consult -> consult[1]).reduce(0, Integer::sum);
		maxRevenue = Math.max(maxRevenue, sum);
		// 현재 시간, 현재 조합, 나머지 상담 일자로 재귀를 돈다.
		while(now<=N) {
			int[] consult = others.get(now);
			if(now + consult[0] <= others.size() && now >= limit) {
				com.put(now, consult);
				others.remove(now);
				limit += consult[0];
			}
			else now++;
			recursive(now, limit, com, others, N);
		}
	}
}
