package com.exercise.ps.softeer;

import java.io.*;

public class AutoMap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[16];
        int[] rp = new int[16];
        dp[0] = 4;
        rp[0] = 2;
        dp[1] = 3*3;
        rp[1] = 3;
        for(int i=2; i<=n; i++) {
            rp[i] = rp[i-1] + (int)Math.pow(2,i-1);
            dp[i] = rp[i] * rp[i];
        }
        System.out.print(dp[n]);
    }
}
