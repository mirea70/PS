package com.exercise.ps.Programmers.code_challenge;

import java.util.HashSet;
import java.util.Set;

public class CodeChallenge_pre_1_lv1 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // timelogs를 순회
        for(int i=0; i<schedules.length; i++) {
            // 직원 별로 이벤트 유효한지 체크
            // 유효하면 카운트
            if(isValid(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }
        // 순회 끝
        return answer;
    }

    // 이벤트 유효 체크함수
    private boolean isValid(int schedule, int[] timelog, int startday) {
        // schedule로 목표 출근 시간 계산해서 limit에 저장
        int limit = getLimit(schedule);
        // startday로 주말인 인덱스 구해서 저장
        Set<Integer> weekendIdx = getWeekendIdx(startday);
        // timelog 순회
        for(int i=0; i<timelog.length; i++) {
            // 주말이면 패스
            if(weekendIdx.contains(i)) continue;
            // 값이 limit을 초과하면 false 반환
            if(timelog[i] > limit) return false;
        }
        // 순회 끝
        // true 반환
        return true;
    }

    private int getLimit(int schedule) {
        // 10을 더하고나서
        schedule += 10;
        // 10으로 나눈 몫이 6이면 100을 더하고, 60을 뺀다 -> 40을 더한다.
        if((schedule / 10) % 10 == 6) {
            schedule += 40;
        }

        return schedule;
    }

    private Set<Integer> getWeekendIdx(int startday) {
        Set<Integer> set = new HashSet<>();
        // 7일 경우 0과 6이다.
        if(startday == 7) {
            set.add(0);
            set.add(6);
        }
        // 6 - startday와 그 + 1이 주말 인덱스다
        else {
            int idx = 6 - startday;
            set.add(idx);
            set.add(idx+1);
        }
        return set;
    }
}
