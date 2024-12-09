package com.exercise.ps.Programmers.basic;

public class Basic57 {
    public int[] solution(String myString) {
        int[] answer = {};
        // split 함수로 나눠 배열 만들기
        String[] strArr = myString.split("x");
        // 해당 배열 크기만큼으로 정답배열 초기화
        boolean isLastX = myString.charAt(myString.length()-1) == 'x';
        answer = new int[isLastX ? strArr.length + 1 : strArr.length];
        // 배열 순회
        for(int i=0; i< strArr.length; i++) {
        // 길이 세서 숫자 배열에 담음
            answer[i] = strArr[i].length();
        }
        return answer;
    }
}
