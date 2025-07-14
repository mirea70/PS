package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17136 {
    static int[][] map;
    static int max_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 지도 저장
        map = new int[10][10];
        for(int r=0; r<10; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<10; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 색종이 갯수 초기화
        ColorPaper.init();
        // 0,0부터 색종이 넣기 시작
        fill(new boolean[10][10], 0, 0);
        // 최소 갯수 출력
        System.out.print(max_cnt != 0 ? 25 - max_cnt : -1);
    }

    private static boolean fill(boolean[][] fill_map, int sy, int sx) {
        // map 순회
        for(int r=sy; r<10; r++) {
            for(int c=sx; c<10; c++) {
//                System.out.println("r, c = " + r + "," + c);
                // 1만나면 방문하지 색칠안되었을 경우 복사한 뒤, 가장 큰 색종이부터 넣기 시도
                if(map[r][c] == 1 && !fill_map[r][c]) {
                    boolean flag = false;
                    for(int num=5; num>=1; num--) {
                        boolean[][] result = ColorPaper.fill(r, c, fill_map, num);
                        // 성공했을 경우 다음 재귀
                        if(result != null) {
//                            System.out.println(ColorPaper.getSum());
                            flag = true;
                            int ny = c+num >= 10 ? r+1 : r;
                            int nx = c+num >= 10 ? 0 : c+num;

                            flag = fill(result, ny, nx);
                            ColorPaper.unUse(num); // 백트래킹
                        }
                    }
                    // 1을 채워줄 색종이가 부족할경우
                    if(!flag) {
                        return false;
                    }
                }
            }
            sx = 0;
        }
        // 순회 끝
        // 끝까지 도달했으면 색종이 최소 사용수 갱신
//        System.out.println(ColorPaper.getSum());
        if(is_valid(fill_map)) {
            max_cnt = Math.max(max_cnt, ColorPaper.getSum());
        }
        return true;
    }

    private static boolean is_valid(boolean[][] fill_map) {
        for(int r=0; r<10; r++) {
            for(int c=0; c<10; c++) {
                if(map[r][c] == 1 && !fill_map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }


    // 성공하면 복사된 배열 반환
    // 실패하면 null
    static class ColorPaper {
        static int cnt1;
        static int cnt2;
        static int cnt3;
        static int cnt4;
        static int cnt5;

        static void init() {
            cnt1 = 5;
            cnt2 = 5;
            cnt3 = 5;
            cnt4 = 5;
            cnt5 = 5;
        }

        static void use(int num) {
            switch (num) {
                case 1 : cnt1--;
                    break;
                case 2 : cnt2--;
                    break;
                case 3 : cnt3--;
                    break;
                case 4 : cnt4--;
                    break;
                case 5 : cnt5--;
                    break;
            }
        }

        static void unUse(int num) {
            switch (num) {
                case 1 : cnt1++;
                break;
                case 2 : cnt2++;
                    break;
                case 3 : cnt3++;
                    break;
                case 4 : cnt4++;
                    break;
                case 5 : cnt5++;
                    break;
            }
        }

        static boolean check(int num) {
            switch (num) {
                case 1 : if(cnt1 <= 0) return false;
                case 2 : if(cnt2 <= 0) return false;
                case 3 : if(cnt3 <= 0) return false;
                case 4 : if(cnt4 <= 0) return false;
                case 5 : if(cnt5 <= 0) return false;
            }
            return true;
        }

        static int getSum() {
            return cnt1 + cnt2 + cnt3 + cnt4 + cnt5;
        }

        static boolean[][] fill(int y, int x, boolean[][] fill_map, int num) {
            if(!check(num)) {
//                if(num == 1) {
//                    for(int r=0; r<10; r++) {
////                        System.out.println("Arrays.toString(fill_map[r]) = " + Arrays.toString(fill_map[r]));
//                    }
////                    System.out.println("num1 use = " + cnt1);
//                }
                return null;
            }
            int standard = num-1;
            if(x+standard >= 10 || map[y][x+standard] != 1 || y+standard >= 10 || map[y+standard][x] != 1)
                return null;

            boolean[][] copied_map = new boolean[10][10];
            for(int r=0; r<10; r++) {
                copied_map[r] = fill_map[r].clone();
            }

            for(int r=y; r<y+num; r++) {
                for(int c=x; c<x+num; c++) {
                    if(map[r][c] != 1 || copied_map[r][c]) return null;
                    copied_map[r][c] = true;
                }
            }

//            System.out.println("log");
//            System.out.println("use y, x = " + y + "," + x);

//            if(num == 2) {
//                System.out.println("num2 log");
//            }
            use(num);
            return copied_map;
        }
    }
}