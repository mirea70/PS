package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.*;

class TargetNumber {

    private int[] numbers;
    private int answer = 0;

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        // 최초 값을 -로 dfs
        dfs(0, numbers[0] * (-1), target);
        // 최초 값을 +로 dfs
        dfs(0, numbers[0], target);
        return answer;
    }

    private void dfs(int idx, int value, int target) {
        // 현재 값 체크
        // idx >= numbers - 1 길이일 때, target == value이면 카운트
        if(idx >= numbers.length - 1) {
            if(value == target) answer++;
            return;
        }
        // 현재 값 + 다음값을 전해주며 dfs
        dfs(idx+1, value + numbers[idx+1], target);
        // 현재 값 - 다음값을 전해주며 dfs
        dfs(idx+1, value - numbers[idx+1], target);
    }
}
