package main.java.com.exercise.ps.Baekjoon.tp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1806_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int s = Integer.parseInt(input1[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        // 투포인터
        int start = 0; int end = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while(true) {
            // 현재 s 이상이면 갱신, start 올리기
            if(sum >= s) {
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }
            // s 미만이면서 end가 마지막이라면 break
            else if(end >= nums.length-1) {
                break;
            }
            // 아니라면 end 올리고, sum에 더하기
            else {
                end++;
                sum += nums[end];
            }
        }

        if(min == Integer.MAX_VALUE) min = 0;

        System.out.print(min);
    }
}
