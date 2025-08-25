package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR32369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        int target1 = 1;
        int target2 = 1;

        while(N--> 0) {
            target1 += A;
            target2 += B;

            if(target1 == target2) {
                target2--;
            }
            else if(target2 > target1) {
                int temp = target1;
                target1 = target2;
                target2 = temp;
            }
        }
        System.out.print(target1 + " " + target2);
    }
}
