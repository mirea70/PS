package com.exercise.ps.Programmers.basic;

public class Basic53 {
    static StringBuilder oddtotal;
    static StringBuilder unOddtotal;

    public int solution(int[] num_list) {
        int answer = 0;
        // 합친 홀수
        unOddtotal = new StringBuilder();
        // 합친 짝수
        oddtotal = new StringBuilder();
        // num_list 순회
        for(int num : num_list) {
            // - 합치기
            concat(num);
        }
        // 합친홀수 + 합친 짝수 리턴

        return Integer.parseInt(unOddtotal.toString()) + Integer.parseInt(oddtotal.toString());
    }

    // 합치기 함수
    public void concat(int source) {
        if(source % 2 != 0)
            unOddtotal.append(String.valueOf(source));
        else
            oddtotal.append(String.valueOf(source));
    }
}
