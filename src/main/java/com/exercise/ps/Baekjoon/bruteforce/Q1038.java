package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1038 {

    static int count = 0;
    static long ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N >= 1023) {
            System.out.print(-1);
            return;
        }

        numSelect(new StringBuilder(), 0, N);
        System.out.print(ans);
    }

    private static void numSelect(StringBuilder current, int depth, int N) {
        if(ans != -1) return;

        if(depth == 10) {
            if(count == N) {
                ans = Long.parseLong(current.toString());
                return;
            }
            count++;
            return;
        }

        for(int i=0; i<10; i++) {
            if(ans != -1) {
                break;
            }
            // 00103
            if(current.length() != 0) {
                int prev = current.charAt(current.length()-1) - '0';
                // 이전 값이 0일 때
                if(prev == 0) {
                    // 그보다 이전 값 중 하나라도 0이 아닌 것이 있다면 pass
                    if(Long.parseLong(current.toString()) != 0) {
                        continue;
                    }
                }
                // 0이 아닐 때
                else {
                   // 이전 값보다 자신이 크거나 같을 경우 pass
                    if(prev <= i) {
                        continue;
                    }
                }
            }
            current.append(i);
            numSelect(current, depth+1, N);
            current.setLength(current.length()-1);
        }
    }
}
