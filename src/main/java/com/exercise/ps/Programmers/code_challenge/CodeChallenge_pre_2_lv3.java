package com.exercise.ps.Programmers.code_challenge;

import java.util.Arrays;

public class CodeChallenge_pre_2_lv3 {

    static char[] alpha = new char[]{'-', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
            , 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String solution(long n, String[] bans) {
        // 26+1 자리 알파벳 배열 저장
        int plus = 0;
        // bans를 getNum 기준으로 오름차순 정렬
        Arrays.sort(bans, (a, b) -> Long.compare(getNum(a), getNum(b)));
        // 이제 그 인덱스 값이 minus할 값(지운횟수)이다.

        // bans 순회
        for (int i=0; i< bans.length; i++) {
            // bans 크기만큼 지우고나서 n보다 큰지 확인한다.
            // 크지않으면 영향 있다는 것 -> 지웠다는 의미이므로 그만큼 더해줘야함
            long target = getNum(bans[i]);
            if (target - i <= n) {
                plus++;
            }
        }

        // bans 순회 끝
        // 현재 주문을 리턴
        return getMagic(n + plus);
    }

    // n번째 주문 구하기
    private String getMagic(long n) {
        StringBuilder sb = new StringBuilder();
        // 1번째 자리부터 채우고 뒤집기
        int idx = 10;
        while (n > 0) {
            int rem = (int)((n-1) % 26) + 1;
            sb.append(alpha[rem]);
            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }

    // 주문으로 순번 구하기
    private long getNum(String magic) {
        int len = magic.length();
        int idx = magic.length()-1;

        long res = 0;

        for(int i=0; i<len; i++, idx--) {
            char target = magic.charAt(i);
            int powNum = -1;
            for(int j=1; j< alpha.length; j++) {
                if(target == alpha[j]) {
                    powNum = j;
                    break;
                }
            }

            res += powNum * (long) Math.pow(26, idx);
        }

        return res;
    }
}
