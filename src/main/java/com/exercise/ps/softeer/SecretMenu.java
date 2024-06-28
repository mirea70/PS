package com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class SecretMenu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int m = Integer.parseInt(input1[0]);
        int n = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);
        int[] menu = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 사용자 버튼 순회
        boolean isSecret = false;
        outSide: for(int i=0; i<n; i++) {
            if(commands[i] > k) break;
            // 비밀 메뉴 버튼 0번째와 같을시 연속으로 같은지 판단한다.
            if(commands[i] == menu[0]) {
                if(m == 1) {
                    isSecret = true;
                    break outSide;
                }
                int tmp = i;
                int idx = 1;
                tmp++;
                while(idx < m && tmp < n) {
                    if(commands[tmp] > k || menu[idx] > k) break outSide;
                    if(commands[tmp] != menu[idx]) {
                        break;
                    }
                    if(idx == m-1) {
                        isSecret = true;
                        break outSide;
                    }
                    idx++;
                    tmp++;
                }
            }
        }
        String ans = isSecret ? "secret" : "normal";
        System.out.print(ans);
    }
}
