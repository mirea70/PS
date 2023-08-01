package com.exercise.ps;

import java.util.ArrayList;
import java.util.Comparator;

public class q1 {
    public static void main(String[] args) {
        int[][] lotteries = {{100,100,500}, {1000,1000,100}};
        q1_Solution qq = new q1_Solution();
        System.out.println("qq.solution(lotteries) = " + qq.solution(lotteries));
    }
}
class q1_Solution {
    public int solution(int[][] lotteries) {
        int answer = 0;
        // 이차원 배열을 생성
        ArrayList<float[]> list = new ArrayList<>();
        float[] temp;
        // lotteries를 순회
        for (int i = 0; i < lotteries.length; i++) {
            // 인덱스 번호, 당첨 확률, 당첨금액 을 담는다
            temp = new float[lotteries[0].length];
            temp[0] = i;
            temp[1] = (float) lotteries[i][0] / (float) (lotteries[i][1] + 1) * 100;
            temp[2] = lotteries[i][2];
            list.add(temp);
        }
        // 당첨 확률이 높은 순으로 정렬
        list.sort(new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                return (int)(o2[1] - o1[1]);
            }
        });
        ArrayList<float[]> ans_list = new ArrayList<>();
        // 0번 리스트에 담고, 1번부터 0번과 같을때까지 담는다
        int[] tem = new int[lotteries[0].length];
        ans_list.add(list.get(0));
        // 생성한 이차원 배열 순회
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[1] == ans_list.get(0)[1]) ans_list.add(list.get(i));
            else break;
        }
        // 리스트에서 당첨금액이 가장 높은 놈의 인덱스 + 1 리턴
        ans_list.sort(new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                return (int)(o2[2] - o1[2]);
            }
        });
        answer = (int)(ans_list.get(0)[0]) + 1;
        return answer;
    }
}