package com.exercise.ps.Programmers.basic;

public class Basic65 {
    public int solution(int a, int b, int c) {
        int answer = 0;
        // 세 숫자가 모두 다를 경우
        if(a != b && b != c && a != c) {
            answer = a + b + c;
        }
        // 세 숫자 모두 같을 경우
        else if(a == b && b == c) {
            answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }
        // 세 숫자중 2개가 같고, 나머지 하나가 다를 경우
        else {
            answer = (a + b + c) * (a*a + b*b + c*c);
        }
        return answer;
    }
}
