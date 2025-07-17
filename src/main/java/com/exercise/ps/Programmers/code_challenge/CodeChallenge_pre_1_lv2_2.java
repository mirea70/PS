package com.exercise.ps.Programmers.code_challenge;

import java.util.*;

public class CodeChallenge_pre_1_lv2_2 {
    public int solution(int n, int[][] q, int[] ans) {
        Static.m = ans.length;
        Static.ans = ans;
        // q를 인덱스 별로 Set로 초기화
        for(int i=0; i<Static.m; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<5; j++) {
                set.add(q[i][j]);
            }
            Static.q.add(set);
        }
        // n 개중에 숫자 5개 뽑기
        combination(n, 1, new int[5], 0, new boolean[n+1]);
        // 모두 통과한다면 가능 조합 개수 카운트
        return Static.can_pick_cnt;
    }

    // n개 중에 5개 뽑기
    private void combination(int n, int start, int[] current, int depth, boolean[] visit) {
        // 5개 뽑을 때마다 주어진 조건을 모두 통과하는지 체크
        if(depth == 5) {
            if(isValid(current)) {
                Static.can_pick_cnt++;
            }
            return;
        }

        for(int i=start; i<=n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = i;
                combination(n, i+1, current, depth+1, visit);
                visit[i] = false;
            }
        }
    }

    // 해당 숫자 조합이 주어진 조건 통과 테스트
    private boolean isValid(int[] nums) {
        // q 이중 순회
        for(int i=0; i<Static.m; i++) {
            Set<Integer> set = Static.q.get(i);
            int cnt = 0;
            // 선택된 수 각각에 대하여 주어진 q 아이템에 값이 존재한다면 카운트
            for(int j=0; j<5; j++) {
                if(set.contains(nums[j])) {
                    cnt++;
                }
            }
            // 1뎁스 순회 끝
            // ans 값과 카운트 값이 같지 않다면 false 리턴
            if(cnt != Static.ans[i]) {
                return false;
            }
        }
        // 2뎁스 순회 끝
        // true 리턴
        return true;
    }
}

class Static {
    static int can_pick_cnt = 0;
    static List<Set<Integer>> q = new ArrayList<>();
    static int[] ans;
    static int m;
}
