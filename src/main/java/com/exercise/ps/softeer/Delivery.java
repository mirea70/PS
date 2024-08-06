package main.java.com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class Delivery {
    private static int min = Integer.MAX_VALUE;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);
        int[] arr = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();
        // 레일의 순서를 순열로 뽑는다
        // 각 순서별로 프로그램을 돌려서
        // 최소 택배 무게 갱신
        permutation(arr, new int[n], new boolean[n], 0, n, k);
        System.out.print(min);
    }

    private static void permutation(int[] arr, int[] current, boolean[] visited, int depth, int r, int k) {
        if(depth == r) {
            // 현재 뽑은 순서로 프로그램 돌리기
            command(current, k);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            current[depth] = arr[i];
            permutation(arr, current, visited, depth+1, r, k);
            visited[i] = false;
        }
    }

    private static void command(int[] rails, int k) {
        int idx = 0;
        int box = 0;
        int result = 0;
        // k>0 동안 반복
        while(k>0) {
            // rails를 순서대로 m 초과 전까지 상자에 담아 옮긴다
            while(box + rails[idx] <= m) {
                // idx >= rails 길이 이면 0으로 초기화
                box += rails[idx];
                idx++;
                if(idx >= rails.length) idx = 0;
            }

            // k--
            k--;
            // result에 누적
            result += box;
            // box 초기화
            box = 0;
            // 반복 끝
        }
        // 최솟값 갱신
        min = Math.min(min, result);
    }
}
