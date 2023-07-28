package com.exercise.ps.Baekjoon.bruteforce;

import java.util.HashMap;

public class Q14501 {

	public static void main(String[] args) {

	}

}

class Solution_Qu14501 {

	int maxRevenue = 0;
	private int maxRevenue(HashMap<Integer, int[]> consults) {
		// 가능한 조합을 모두 방문한다.

		// 방문마다 maxRevenue 값을 갱신한다.
		// maxRevenue 리턴
	}

	private void recursive(int now, HashMap<Integer, int[]> com, HashMap<Integer, int[]> others) {
		// 현재 조합의 이익 합으로 최댓값 갱신한다.
		int sum = com.values().stream().map(consult -> consult[1]).reduce(0, Integer::sum);
		maxRevenue = Math.max(maxRevenue, sum);
		// 현재 시간, 현재 조합, 나머지 상담 일자로 재귀를 돈다.
		for(int i = 1; i<=others.size(); i++) {
			int[] consult = others.get(i);
			if(i + consult[0] <= others.size())
				com.put(i, consult);
				com.remove(i);
			recursive();
		}

	}
}
