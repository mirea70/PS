package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589 {

    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int N;
    private static int M;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] map = new String[N][M];
        for(int r=0; r<N; r++) {
            map[r] = br.readLine().split("");
        }

        select(map);
        System.out.print(max);
    }

    private static void select(String[][] map) {
//        if(depth == 2) {
//
//
//            Person start = persons.get(0);
//            Person end = persons.get(1);
////            System.out.println("start : " + start.y + ", " + start.x);
////            System.out.println("end : " + end.y + ", " + end.x);
//
//            max = Math.max(max, bfs(copiedMap, start.y, start.x, end.y, end.x));
//            return;
//        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(map[r][c].equals("L")) {
//                    persons.add(new Person(r, c));
//                    select(map, depth+1, persons);
//                    persons.remove(persons.size()-1);
                    String[][] copiedMap = new String[N][M];
                    for(int i=0; i<N; i++) {
                        copiedMap[i] = map[i].clone();
                    }

                    bfs(copiedMap, r, c);
                }
            }
        }
    }

    private static void bfs(String[][] map, int y, int x) {
        map[y][x] = "0";
        Queue<Person> queue = new ArrayDeque<>();
        queue.add(new Person(y, x));
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            Person person = queue.poll();
            int cy = person.y;
            int cx = person.x;

            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                // 벽이면 패스
                if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                // 방문하지 않았으면 : L이면
                // 큐에 담기, map에 + 1 더한값 채우기
                if(map[ny][nx].equals("L")) {
                    map[ny][nx] = String.valueOf(Integer.parseInt(map[cy][cx]) + 1);
                    max = Math.max(max, Integer.parseInt(map[ny][nx]));
                    queue.add(new Person(ny, nx));
                }
            }
        }

//        if(y == 3 && x == 0 && ty == 4 && tx == 1) {
//            System.out.println("Arrays.deepToString(map) = " + Arrays.deepToString(map));
//            System.out.println("ty, tx = " + ty + ", " + tx);
//        }

        // 반복 끝
        // ty, tx값 반환

    }

    static class Person {
        int y;
        int x;

        public Person(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
