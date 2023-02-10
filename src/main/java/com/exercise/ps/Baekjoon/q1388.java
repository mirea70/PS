package com.exercise.ps.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class q1388 {
    static ArrayList<ArrayList<String>> map = new ArrayList<>();
    static int box = 0;
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        // 2차원 리스트에 판자를 담는다
        map.add(new ArrayList<>());

        String[] inp = bw.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        M = Integer.parseInt(inp[1]);
        for (int i = 0; i < N; i++) {
            String[] temp = bw.readLine().split("");
            ArrayList<String> tmp_list = new ArrayList<>();
            tmp_list.add("x");
            tmp_list.addAll(Arrays.asList(temp));
            map.add(tmp_list);
        }

        // 1,1 부터 dfs를 돌린다
        for (int i = 1; i < map.size(); i++) {
            for (int j = 1; j < map.get(1).size(); j++) {
                dfs(i, j);
            }
        }
    }

    private static void dfs(int y, int x) {
        // 현재 판자가 - 라면 우측 판자를 확인한다
        if (map.get(y).get(x).equals("-")) {
            // 방문체크
            map.get(y).set(x, "o");
            // 우측 판자도 - 라면 dfs 돌기
            if (x + 1 <= M && map.get(y).get(x + 1).equals("-")) {
                dfs(y, x + 1);

            } else {
                // 아니라면 판자개수 ++
                box++;
            }
        } else if (map.get(y).get(x).equals("|")) {
            // 방문 체크
            map.get(y).set(x, "o");
            // 현재 판자가 | 라면 밑쪽 판자를 확인한다
            if (map.get(y).get(x).equals("|")) {
                // 밑쪽 판자가 | 아니라면 판자개수 ++
                if (y + 1 <= N && !map.get(y + 1).get(x).equals("|")) {
                    box++;
                }
                if(y == N) box++;
            }
        }
    }
}

class test_q1388 {

}
