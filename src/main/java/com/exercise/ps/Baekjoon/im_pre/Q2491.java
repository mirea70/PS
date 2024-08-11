package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max_len = n == 1 ? 1 : 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean plus_ing = false;
        boolean minus_ing = false;
        int prev_val = Integer.parseInt(st.nextToken());
        int plus_len = 1;
        int minus_len = 1;
        for(int i=1; i<n; i++) {
            int current_val = Integer.parseInt(st.nextToken());

            if(!plus_ing && !minus_ing) {
                if(current_val >= prev_val) {
                    plus_ing = true;
                    plus_len++;
                }
                if(current_val <= prev_val) {
                    minus_ing = true;
                    minus_len++;
                }
            }
            else if(plus_ing && !minus_ing) {
                if(current_val >= prev_val) {
                    plus_len++;
                    max_len = Math.max(max_len, plus_len);
                }
                else {
                    plus_len = 1;
                    plus_ing = false;
                }

                if(current_val <= prev_val) {
                    minus_ing = true;
                    minus_len = 2;
                }
            }
            else if(!plus_ing && minus_ing) {
                if(current_val >= prev_val) {
                    plus_ing = true;
                    plus_len = 2;
                }

                if(current_val <= prev_val) {
                    minus_len++;
                    max_len = Math.max(max_len, minus_len);
                }
                else {
                    minus_len = 1;
                    minus_ing = false;
                }
            }
            else {
                if(current_val >= prev_val) {
                    plus_len++;
                    max_len = Math.max(max_len, plus_len);
                }
                else {
                    plus_len = 1;
                    plus_ing = false;
                }

                if(current_val <= prev_val) {
                    minus_len++;
                    max_len = Math.max(max_len, minus_len);
                }
                else {
                    minus_len = 1;
                    minus_ing = false;
                }
            }

            prev_val = current_val;
        }
        System.out.print(max_len);
    }
}
