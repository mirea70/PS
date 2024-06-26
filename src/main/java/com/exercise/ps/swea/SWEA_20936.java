package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SWEA_20936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            List<Integer> kList = new ArrayList<>();
            List<Integer> list = new LinkedList<>();
            list.add(-1);
            // 리스트에 박스들 담기
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for(String s : input)
                list.add(Integer.parseInt(s));
            list.add(0);
            // 이미 올바른지 체크 boolean true
            boolean already = true;
            // 리스트 역방향으로 순회
            for(int i=n; i>=1; i--) {
                // 현 위치가 원하는 위치가 아닐 경우 맨 우측으로 보내고 이미 올바른 boolean = false  순회 끝
                if(list.get(i) != i) {
                    int idx = list.lastIndexOf(i);
                    list.set(n+1, i);
                    list.set(idx, 0);
                    already = false;
                    break;
                }
            }
            // boolean == true이면서 맨 우측 값이 0이 아닐 동안 반복
            while(!already && list.get(n+1) != 0) {
                // 현재 값이 0인 인덱스 찾는다.
                int idx0 = list.lastIndexOf(0);
                // 그 인덱스를 값으로 가진 인덱스를 찾는다.
                int idxVal = list.lastIndexOf(idx0);
                // 해당 값을 현재 0인 인덱스로 넣고, 원래 자리는 0으로 바꾼다.
                list.set(idx0, idx0);
                list.set(idxVal, 0);
                // 원래 0이었던 인덱스를 kList에 추가한다.
                kList.add(idx0);
            }
            // 반복 끝
            // k의 개수 출력
            int k = kList.size();
            // k > 0 이면 리스트 값들 하나 띄어써서 출력
            if(k > 0) {
                StringBuilder sb = new StringBuilder();
                // k 마지막 추가
                kList.add(n+1);
                System.out.println(k);
                for(int num : kList)
                    sb.append(num).append(" ");
                System.out.println(sb.toString());
            }
            else System.out.println(k);
        }
    }
}
