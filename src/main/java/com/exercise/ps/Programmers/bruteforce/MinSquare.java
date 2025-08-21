package com.exercise.ps.Programmers.bruteforce;

public class MinSquare {
    public int solution(int[][] sizes) {
        // 명함 중, 작은 길이 중 최대값 * 큰 길이 중 최대값이 정답이다
        int smallMax = 0;
        int largeMax = 0;
        for(int[] size : sizes) {
            smallMax = Math.max(smallMax, Math.min(size[0], size[1]));
            largeMax = Math.max(largeMax, Math.max(size[0], size[1]));
        }

        return smallMax * largeMax;
    }
}
