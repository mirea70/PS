package main.java.com.exercise.ps.Programmers.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class greedy_3 {
    public static void main(String[] args) {
        greedy_3_Solution g3 = new greedy_3_Solution();

        String number = "4177252841";
        int k = 4;

        System.out.println("결과는 = " + g3.solution(number, k));
    }
}
class greedy_3_Solution {
    public String solution(String number, int k) {
        String answer = "";
        // number를 stringBuilder에 담는다
        StringBuilder sb = new StringBuilder(number);
        // 현재 인덱스 now
        int now = 0;
        // 임시 k 값
        int temp = 0;
        // sb 길이
        int len = 0;
        // k != 0 일동안 반복
        while(k != 0) {
            // k값 임시저장
            temp = k;
            // sb 길이 값을 초기화
            len = sb.length();
            // 길이 직전까지 순회
            for(int i=0;i<len;i++){
                // i 값이 len - 1이면 해당 값 삭제
                if(i == len - 1) {
                    sb.deleteCharAt(i);
                    k--;
                    break;
                }
                // 다음 값이 더 크면 해당 값 삭제
                if(sb.charAt(i) < sb.charAt(i+1)) {
                    sb.deleteCharAt(i);
                    k--;
                    break;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
