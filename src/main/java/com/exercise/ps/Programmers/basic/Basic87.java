package com.exercise.ps.Programmers.basic;

public class Basic87 {
    public int solution(String myString, String pat) {
        int answer = 0;

        // 슬라이딩 윈도우
        int left = 0;
        int right = pat.length();
        boolean isSame;

        while(right <= myString.length()) {
            isSame = true;
            for(int i=left; i<right; i++) {
                if(myString.charAt(i) != pat.charAt(i-left)) {
                    isSame = false;
                }
            }

            if(isSame)
                answer++;

            left++;
            right++;
        }

        return answer;
    }
}
