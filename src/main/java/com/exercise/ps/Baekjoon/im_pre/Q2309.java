package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {

    private static boolean is_find = false;
    private static int[] ans = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아홉 난쟁이 입력
        int[] persons = new int[9];
        for(int i=0; i<9; i++) {
            persons[i] = Integer.parseInt(br.readLine());
        }
        // 9난쟁이 중, 7난쟁이를 뽑는다. (조합)
        combination(persons, new boolean[9], new int[7], 0, 0, 7);
        // 난장이들 오름차순
        Arrays.sort(ans);
        // 난장이들 출력
        for(int person : ans)
            System.out.println(person);
    }

    private static void combination(int[] arr, boolean[] visited, int[] current, int depth, int start, int r) {
        if(is_find) return;

        if(depth == r) {
            // 키의 합이 100일 경우 is_find = true, current를 ans에 저장
            int sum=0;
            for(int height : current)
                sum += height;
            if(sum == 100) {
                is_find = true;
                ans = Arrays.copyOfRange(current,0, current.length);
            }
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = arr[i];
                combination(arr, visited, current, depth+1, i+1, r);
                visited[i] = false;
            }
        }
    }
}
