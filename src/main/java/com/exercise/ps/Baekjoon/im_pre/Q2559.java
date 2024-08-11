package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        // k개 우선 더하기
        int sum = 0;
        for(int i=0; i<k; i++) {
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            nums[i] = val;
        }
        // left, right = 0 <- right-left+1 == k일때마다 해당 구간합의 최대값을 갱신
        int left = 0;
        int right = k;

        int max = sum;

        // right < n일동안 반복
        while(right < n) {
            int val = Integer.parseInt(st.nextToken());
            nums[right] = val;
            sum += val;
            sum = sum - nums[left];
            ++left;
            ++right;
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}
