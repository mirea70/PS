package main.java.com.exercise.ps.Baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = i + 1;
        }
        int[] output = new int[N];
        boolean[] visit = new boolean[N];

        perm(arr, output, visit, 0, r);
    }

    private static void perm(int[] arr, int[] output, boolean[] visit , int depth, int r) {
        if(depth == r) {
            for(int i=0; i<r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i< arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                output[depth] = arr[i];

                perm(arr, output, visit, depth + 1, r);
                visit[i] = false;
            }
        }
    }
}
