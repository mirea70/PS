package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD2262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // 추첨 결과를 list에 담는다
        List<Integer> list = new LinkedList<>();
        st =  new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int max = N;
        // 큐 빌때까지 반복
        while(max > 1) {

            int curIdx = list.indexOf(max);
            // 리스트 상 좌우 중 차이 작은 값과 매칭 (차이값 누적)
            int add = 0;
            // - 가장 왼쪽이면 자신 오르쪽
            if(curIdx == 0) {
                add = max - list.get(curIdx+1);
            }
            // - 가장 우측이면 자신 왼쪽
            else if(curIdx == list.size()-1){
                add = max - list.get(curIdx-1);
            }
            // - 중간이면 왼쪽오른쪽 중 차이 작은값과 비교
            else {
                add = Math.min(max - list.get(curIdx-1), max - list.get(curIdx+1));
            }
            list.remove(curIdx);
            sum += add;
            max--;
        }
        // 반복 끝
        // 누적된 차이값 출력
        System.out.print(sum);
    }
}
