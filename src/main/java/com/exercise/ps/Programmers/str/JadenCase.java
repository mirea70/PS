package main.java.com.exercise.ps.Programmers.str;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // s 순회
        for(int i=0; i<arr.length; i++) {
            // 단어의 첫문자일 경우 (i ==0이거나 현문자가 공백이아니면서 전 문자가 공백)
            char now = arr[i];
            if(now != ' ') {
                if(i==0 || arr[i-1] == ' ') {
                    // 숫자가 아니면 -> 대문자로바꿈
                    if(!Character.isDigit(now))
                        arr[i] = Character.toUpperCase(now);
                }
                else {
                    // 현문자 공백아니면 -> 소문자
                    arr[i] = Character.toLowerCase(now);
                }
            }
            // 순회 끝
        }
        answer = new String(arr);
        return answer;
    }
}