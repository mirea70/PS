package com.exercise.ps.Programmers.basic;

public class Basic56 {
    public String solution(String n_str) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        // n_str 순회
        for(char c : n_str.toCharArray()) {
            // flag true이면 StringBulder에 담는다
            if(flag)
                sb.append(c);
            else {
                // flag false이면 0인지 체크
                // 찾으면 flag : true
                if(c != '0') {
                    flag = true;
                    sb.append(c);
                }
            }
        }
        // 순회 끝
        // StringBulder 리턴

        return sb.toString();
    }
}
