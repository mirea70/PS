package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] persons = new int[9];
        for(int i=0; i<9; i++) {
            persons[i] = Integer.parseInt(br.readLine());
        }

        // 9명 중 7명 뽑기 - 합이 100일 경우 재귀 종료
        int[] result = combination(persons, new int[7], 0, 0);
        Arrays.sort(result);
        for(int r : result)
            System.out.println(r);
    }

    private static int[] combination(int[] arr, int[] current, int start, int depth) {
        if(depth == 7) {
            return current;
        }

        for(int i=start; i<arr.length; i++) {
            current[depth] = arr[i];
            int[] result = combination(arr, current, i+1, depth+1);
            int sum = Arrays.stream(result).sum();
            if(sum == 100) return result;

            current[depth] = 0;
        }

        return new int[]{-1};
    }
}
