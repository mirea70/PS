package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.*;

public class NumPresent {

    int cnt = 0;

    public int solution(int n) {

        // n까지 1씩증가하며 순회
        int num = 1;
        while(num <= n) {
            // 각 수를 기준으로 재귀
            dfs(num, num, n);
            num++;
        }
        return cnt;
    }

    private void dfs(int now, int sum, int target) {
        // start > target이면 리턴
        if(now > target || sum > target) return;
        // 합 == target이면 갯수증가, 리턴
        if(sum == target) {
            cnt++;
            return;
        }
        // start, sum 증가시켜서 dfs
        int next = now+1;
        dfs(next, sum + next, target);
    }
}