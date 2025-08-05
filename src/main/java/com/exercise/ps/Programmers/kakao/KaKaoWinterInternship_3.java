package com.exercise.ps.Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KaKaoWinterInternship_3 {

    static class Static {
        static double maxWinCnt = 0;
        static int[] maxWinCom;
        static int[][] CommonDice;
        static List<Integer> sumA;
        static List<Integer> sumB;
    }

    public int[] solution(int[][] dice) {
        // A가 뽑을 주사위 인덱스들을 N/2만큼 뽑는다.
        // A가 뽑은 주사위들과 그에따라 자동으로 뽑힌 주사위 인덱스들을 조합해
        // 승률을 계산한다. -> 승률에 따라 최대 승률 및 최다승률 조합을 갱신
        int n = dice.length;
        Static.maxWinCom = new int[n/2];
        Static.CommonDice = dice;

        combination(n, new boolean[n], 0, 0);
        // 최다 승률 조합을 오름차순 정렬하여 반환
        Arrays.sort(Static.maxWinCom);
        return Static.maxWinCom;
    }

    private void combination(int n, boolean[] visit, int start, int depth) {
        if(depth == n/2) {
            int[] combinationA = new int[n/2];
            int[] combinationB = new int[n/2];

            int aIdx = 0;
            int bIdx = 0;

            for(int i=0; i<n; i++) {
                if(visit[i]) {
                    combinationA[aIdx] = i;
                    aIdx++;
                }
                else {
                    combinationB[bIdx] = i;
                    bIdx++;
                }
            }
            calculateWinChance(combinationA, combinationB);
            return;
        }

        for(int i=start; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(n, visit, i+1, depth+1);
                visit[i] = false;
            }
        }
    }

    private void calculateWinChance(int[] aIdx, int[] bIdx) {
        // A, B의 주사위들의 합분포 리스트를 채운다 (먼저 초기화하고)
        Static.sumA = new ArrayList<>();
        Static.sumB = new ArrayList<>();
        sumCombination(aIdx, Static.sumA, 0, 0);
        sumCombination(bIdx, Static.sumB, 0, 0);
        // 누적된 승, 패, 무 데이터로 승률 계산해 갱신
//        System.out.println("A = " + Arrays.toString(aIdx));
//        System.out.println("B = " + Arrays.toString(bIdx));
//        System.out.println("승 = " + Static.win);
//        System.out.println("패 = " + Static.lose);
//        System.out.println("무 = " + Static.same);

        // B를 정렬하고, 각 A마다 주사위 합이 큰 경우의 인덱스를 구하고, 그 인덱스+1이 승수이다. -> 이분탐색으로 구한다.
        Collections.sort(Static.sumB);
        int winCnt = 0;

        int len = Static.sumA.size();
        for(int i=0; i<len; i++) {
            int target = Static.sumA.get(i);
//            System.out.println("target = " + target);

            int s = 0;
            int e = Static.sumB.size() - 1;
            int index = -1;
            while(s <= e) {
                int mid = (s + e) / 2;
//                System.out.println("B mid = " + Static.sumB.get(mid));
                if(Static.sumB.get(mid) >= target) {
                    e = mid-1;
                }
                else {
                    index = Math.max(index, mid);
                    s = mid+1;
                }
            }

            if(index != -1) {
                winCnt += index + 1;
            }
        }

        // 해당 조합의 승수를 모두 구했으면 최대 승수와 그 조합을 갱신
        if(winCnt > Static.maxWinCnt) {
            Static.maxWinCnt = winCnt;
            for(int i=0; i<aIdx.length; i++) {
                Static.maxWinCom[i] = aIdx[i] + 1;
            }
        }
    }

    // a의 각 조합마다 0~5번 인덱스에 담긴 숫자를 선택해서 더한다. 더한 값을 분포 리스트에 담는다.
    private void sumCombination(int[] combination, List<Integer> sumArr, int sum, int depth) {
        if(depth == combination.length) {
            sumArr.add(sum);
            return;
        }

        for(int i=0; i<6; i++) {
            sumCombination(combination, sumArr, sum + Static.CommonDice[combination[depth]][i], depth+1);
        }
    }

//    private void updateScore(int[] combination, int sum, int targetSum, int depth) {
//        if(depth == combination.length) {
//            if(targetSum > sum) {
//                Static.win++;
//            }
//            else if(targetSum < sum) {
//                Static.lose++;
//            }
//            else {
//                Static.same++;
//            }
//            return;
//        }
//
//        for(int i=0; i<6; i++) {
//            updateScore(combination, sum + Static.CommonDice[combination[depth]][i], targetSum, depth+1);
//        }
//    }
}
