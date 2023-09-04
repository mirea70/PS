package com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q21608 {

    // 위치 후보 리스트 생성
    static List<int[]> position_infos = new ArrayList<>();
    static int[][] map;
    static int[][] likes;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int N;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        int peopleCnt = (int) Math.pow((double) N, 2);
        likes = new int[peopleCnt + 1][5];
        // 반목문
        for(int i=1; i<= peopleCnt; i++) {
            // 순서대로 자리정하여 맵을 채운다
            st = new StringTokenizer(br.readLine());

            int[] temp = new int[5];
            for(int j=0; j<5; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            likes[temp[0]] = temp;
            fillRoom(temp);
        }
        // 맵을 순회하며 만족도의 총합을 구한다
        int sum = 0;
        for(int i=1; i<= N; i++) {
            for(int j=1; j<= N; j++) {
                sum += getScore(i, j);
            }
        }
        // 총합을 출력한다
        System.out.println(sum);
    }

    private static void fillRoom(int[] likes) {
        // 1,1부터 교실 순회
        for(int i=1; i<= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 값 = 0이면
                if(map[i][j] == 0) {
                    // 위치 정보 생성
                    // 상하좌우 체크 -> 비어있는 칸, 좋아하는멤버 수 세기
                    int blank = 0;
                    int like_cnt = 0;
                    for(int k=0; k<4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if(ny < 1 || ny > N || nx <1 || nx > N) continue;
                        if(map[ny][nx] == 0) blank++;
                        else {
                            for(int z = 1; z<=4; z++) {
                                if(likes[z] == map[ny][nx]) like_cnt++;
                            }
                        }
                    }
                    // 체크 끝 -> 비어있는 칸, 좋아하는 멤버 수 채우기
                    int[] info = new int[]{i,j,blank,like_cnt};
                    // 리스트에 담기
                    position_infos.add(info);
                }
            }
        }
        // 순회 끝
        // 리스트 정렬
        // 좋아하는 수 내림차순, 비어있는칸 내림차순, y 오름차순, x 오름차순 순으로
        Collections.sort(position_infos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[3] == o2[3]) {
                    if(o1[2] == o2[2]) {
                        if(o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        else return o1[0] - o2[0];
                    }
                    else return o2[2] - o1[2];
                }
                else return o2[3] - o1[3];
            }
        });
        // 리스트의 0번째의 y, x값에 해당하는 맵의 위치에 index 넣기
        int[] value = position_infos.get(0);
        map[value[0]][value[1]] = likes[0];
        // 리스트 클리어
        position_infos.clear();
    }

    private static int getScore(int y, int x) {
        // 해당하는 맵 값의 인덱스를 가진 likes
        int cnt = 0;
        // 상하좌우 체크 -> 좋아하는 수 체크
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 1 || ny > N || nx <1 || nx >N) continue;
            for(int z = 1; z<=4; z++) {
                if(likes[map[y][x]][z] == map[ny][nx]) cnt++;
            }
        }
        // 점수 리턴
        int result = 0;
        switch (cnt) {
            case 0:
                break;
            case 1:
                result = 1;
                break;
            case 2:
                result = 10;
                break;
            case 3:
                result = 100;
                break;
            case 4:
                result = 1000;
                break;
        }
        return result;
    }
}
