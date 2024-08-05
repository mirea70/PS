package main.java.com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        System.out.print(change(Integer.parseInt(ab[0]), Integer.parseInt(ab[1]))+1);
    }

    private static int change(int A, int B) {
        int cnt = 0;
        // B 대상
        while(A <= B) {
            if(A == B) {
                return cnt;
            }
            // 짝수일때
            if (B % 2 ==0) {
                B = B/2;
            }
            // 홀수일때
            else {
                String s = String.valueOf(B);
                char last = s.charAt(s.length()-1);
                // 끝자리가 1일때
                if(last == '1') {
                    s = s.substring(0,s.length()-1);
                    B = Integer.parseInt(s);
                }
                // 아닐때
                else {
                    return -2;
                }
            }
            cnt++;
        }
        return -2;
    }
}
