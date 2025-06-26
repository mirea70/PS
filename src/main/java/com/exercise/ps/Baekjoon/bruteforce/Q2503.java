package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2503 {
    static int cnt = 0;
    static Validator validator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        validator = new Validator();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            validator.add(value, strike, ball);
        }
        perm(new boolean[10], new StringBuilder());
        System.out.print(cnt);
    }

    // 1~9 중에 중복없이 3개를 뽑는다
    private static void perm(boolean[] visit, StringBuilder current) {
        if(current.length() == 3) {
            // 통과해야하는 모든 규칙이 통과되는지 확인한다.
            // 모두 통과할 경우 카운트
            if(validator.isValid(current.toString())) {
                cnt++;
            }
            return;
        }

        for(int i=1; i<10; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current.append(i);
                perm(visit, current);
                current.setLength(current.length()-1);
                visit[i] = false;
            }
        }
    }



}

class Validator {
    List<String> strList;
    List<Integer> strikes;
    List<Integer> balls;
    int size;

    public Validator() {
        this.strList = new ArrayList<>();
        this.strikes = new ArrayList<>();
        this.balls = new ArrayList<>();
        this.size = 0;
    }

    public void add(String value, int strike, int ball) {
        strList.add(value);
        strikes.add(strike);
        balls.add(ball);
        size++;
    }

    public boolean isValid(String value) {
        for(int i=0; i<size; i++) {
            String target = strList.get(i);
            int strike = 0;
            int ball = 0;
            for(int vi=0; vi<3; vi++) {
                for(int ti=0; ti<3; ti++) {
                    if(vi == ti && value.charAt(vi) == target.charAt(ti)) {
                        strike++;
                    }
                    else if(vi != ti && value.charAt(vi) == target.charAt(ti)) {
                        ball++;
                    }
                }
            }
            if(!(strike == strikes.get(i) && ball == balls.get(i))) {
                return false;
            }
        }
        return true;
    }

}
