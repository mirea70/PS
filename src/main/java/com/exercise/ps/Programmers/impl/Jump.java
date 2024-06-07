package com.exercise.ps.Programmers.impl;

import java.util.*;

public class Jump {

    public static void main(String[] args) {

    }

    static int n;
    static int ans;

    public int solution(int n) {
        Jump.n = n;
        ans = n;
        move(1,1);

        return ans;
    }
    // 순간이동/한칸이동
    private static void move(int now, int total) {
        // now > n : return
        if(now > n) return;
        // now == n : 개수 갱신
        if(now == n) {
            Math.min(ans, total);
            return;
        }
        // 순간이동
        move(now*2, total);
        // 한칸이동
        move(now+1, total+1);
    }
}
