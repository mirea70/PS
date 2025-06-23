package com.exercise.ps.Baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1062_2 {
    static int N, K;
    static int[] wordMasks;
    static int max = 0;

    static final int BASE_MASK =
            (1 << ('a' - 'a')) |
                    (1 << ('n' - 'a')) |
                    (1 << ('t' - 'a')) |
                    (1 << ('i' - 'a')) |
                    (1 << ('c' - 'a'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);

        if(K < 5) {
            System.out.print(0);
            return;
        }

        wordMasks = new int[N];
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            wordMasks[i] = mask;
        }

        dfs(0, 0, BASE_MASK);
        System.out.print(max);
    }

    static void dfs(int idx, int depth, int teachMask) {
        if(depth == K - 5) {
            int count = 0;
            for(int mask : wordMasks) {
                if ((mask & teachMask) == mask) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for(int i=idx; i<26; i++) {
            int bit = 1 << i;
            if ((teachMask & bit) !=  0) continue;
            dfs(i+1, depth+1, teachMask | bit);
        }
    }
}
