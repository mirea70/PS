package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 기둥 입력
        List<int[]> buildings = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            buildings.add(new int[]{x, h});
        }
        // 기둥 0번째 기준 오름차순 정렬
        buildings.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 최대값 <- 첫번째 기둥 기준 초기화하고 시작
        int max = buildings.get(0)[1];
        // 이전 x값 저장
        int prev_x = buildings.get(0)[0];
        List<int[]> tmp_list = new ArrayList<>();
        int sum = n == 1 ? max : 0;
        // 마지막 x값
        int last_x = buildings.get(buildings.size()-1)[0];
        // 기둥 배열 1번째부터 순회
        for(int i=1; i<n; i++) {
            int[] now = buildings.get(i);
            // - 현재값 >= max일 경우
            if(now[1] >= max) {
                // -- (현재 x값 - 이전 x값) * 이전 최대값 누적
                sum += (now[0] - prev_x) * max;
                // -- 임시 리스트 비운다
                tmp_list.clear();
                // max 갱신
                max = now[1];
                prev_x = now[0];
            }
            // - 현재값 < max이면
            else {
                // -- 현재값을 임시 리스트에 담는다
                tmp_list.add(now);
            }
            // - 마지막 기둥일 경우
            if(i == n-1) {
                // 최대값 먼저 누적
                sum += max;

                prev_x++;
                // -- 임시 리스트 높이기준 내림차순 정렬
                tmp_list.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1] - o1[1];
                    }
                });
                // -- 최대값부터 차례대로 순회
                for(int j=0; j<tmp_list.size(); j++) {
                    // -- 아직 덜돌았는데, 마지막일 경우
                    int idx = tmp_list.get(j)[0];
                    if(idx == last_x) {
                        // -- 면적 구하고 끝내기
                        sum += (idx + 1 - prev_x) * tmp_list.get(j)[1];
//                        System.out.println((idx + 1 - prev_x) * tmp_list.get(j)[1]);
                        break;
                    }
                    else {
                        // 이미 해당 인덱스 넘겼으면 패스
                        if(prev_x > idx) continue;
//                        System.out.println((idx + 1 - prev_x) * tmp_list.get(j)[1]);
                        sum += (idx + 1 - prev_x) * tmp_list.get(j)[1];
                        prev_x = idx + 1;
                    }
                }
            }
        }
        // 순회 끝
        // 면적 출력
        System.out.print(sum);
    }
}
