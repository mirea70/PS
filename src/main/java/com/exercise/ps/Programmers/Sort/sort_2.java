package main.java.com.exercise.ps.Programmers.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class sort_2 {
    public static void main(String[] args) {

    }
}
class sort_2_Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // numbers을 문자열 배열로 바꿈
        String[] strs = new String[numbers.length];
        for(int i =0;i<numbers.length;i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        // 문자열 배열을 내림차순 정렬
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String n1, String n2) {
                return (n2 + n1).compareTo(n1 + n2);
            }
        });

        if(strs[0].equals("0")) return "0";

        // 문자열 배열을 순회하며 answer에 집어넣기
        for(String s : strs) answer += s;
        return answer;
    }
}