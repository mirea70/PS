package com.exercise.ps.Programmers.basic;

public class Basic76 {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        char[][] map = new char[len/m + 1][m+1];
        // map 그리기
        for(int i=0; i<len; i++) {
            // 행계산
            int row = i/m + 1;
            // 열계산
            int col = i%m + 1;
            map[row][col] = my_string.charAt(i);
        }
        // map 순회하며, 각행의 c열의 글자들을 문자열로 합침
        for(int r=1; r<len/m + 1; r++) {
            char val = map[r][c];
            if(r == len/m && val == '\u0000') {
                continue;
            }

            sb.append(val);
        }
        // 합친 문자열 반환

        return sb.toString();
    }
}
