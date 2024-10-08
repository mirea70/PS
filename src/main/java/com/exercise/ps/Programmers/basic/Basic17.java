package com.exercise.ps.Programmers.basic;

public class Basic17 {
    public String[] solution(String[] strArr) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strArr.length; i++) {
            if(i % 2 != 0) {
                for(char c : strArr[i].toCharArray()) {
                    sb.append(Character.toUpperCase(c));
                }
                strArr[i] = sb.toString();
                sb.setLength(0);
            }
            else {
                for(char c : strArr[i].toCharArray()) {
                    sb.append(Character.toLowerCase(c));
                }
                strArr[i] = sb.toString();
                sb.setLength(0);
            }
        }
        return strArr;
    }
}
