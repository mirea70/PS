package com.exercise.ps.Programmers.Dfs_Bfs;

public class TargetNumber2 {
    int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return count;
    }

    private void dfs(int[] numbers, int depth, int target, int now) {
        // depth가 배열의 끝과 같을때
        if(depth == numbers.length) {
            // - target과 같으면 카운트
            if(now == target)
                count++;
            return;
        }

        // 더하기
        dfs(numbers, depth+1, target, now+numbers[depth]);
        // 빼기
        dfs(numbers, depth+1, target, now-numbers[depth]);
    }
}
