package com.exercise.ps.Baekjoon.bruteforce;

import java.util.HashMap;
import java.util.Scanner;

public class Q14501 {

    public static void main(String[] args) {
        Solution_Qu14501 ss = new Solution_Qu14501();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, int[]> consults = new HashMap<>();
        for (int i = 1; i <= N; i++) {
//			String aa = sc.nextLine();
            String[] strArr = sc.nextLine().split(" ");
            int[] intArr = {Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])};
            consults.put(i, intArr);
        }
        int maxRevenue = ss.maxRevenue(consults, N);
        System.out.println(maxRevenue);
    }

}

class Solution_Qu14501 {

    int maxRevenue = 0;
    int N = 0;

    public int maxRevenue(HashMap<Integer, int[]> consults, int N) {
        this.N = N;
        // 가능한 조합을 모두 방문 및 이익 최대값 갱신
        recursive(1, new HashMap<>(), consults);
        // maxRevenue 리턴
        return maxRevenue;
    }

    private void recursive(int now, HashMap<Integer, int[]> com, HashMap<Integer, int[]> others) {

        // 현재 조합의 이익 합으로 최댓값 갱신한다.
        if (now >= N) {
            int sum = com.values().stream().map(consult -> consult[1]).reduce(0, Integer::sum);
            maxRevenue = Math.max(maxRevenue, sum);
            return;
        }
        // 현재 시간, 현재 조합, 나머지 상담 일자로 재귀를 돈다.
        if (others.size() > 0) {
            int[] consult = others.get(now);

            if (consult != null && now + consult[0] <= N) {
                com.put(now, consult);
                others.remove(now);
                recursive(now + consult[0], com, others);
            }
        }

        recursive(now + 1, com, others);
    }
}
