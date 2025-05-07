package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic104 {
    public String[] solution(String[] str_list) {
        int stdIdx = -1;
        char status = '-';

        // str_list 순회
        for(int i=0; i< str_list.length; i++) {
            String str = str_list[i];
            // l만나면 stdIdx 현재 인덱스, status l로 바꾸고 중지
            if(str.equals("l")) {
                stdIdx = i;
                status = 'l';
                break;
            }
            // r만나면 stdIdx 현재 인덱스, status r로 바꾸기
            else if(str.equals("r")) {
                stdIdx = i;
                status = 'r';
                break;
            }
        }
        // 순회 끝

        // status l이면 stdIdx 까지의 배열 복사해 리턴
        switch (status) {
            case 'l' : return Arrays.copyOfRange(str_list, 0, stdIdx);
            case 'r' : return Arrays.copyOfRange(str_list, stdIdx+1, str_list.length);
        }

        // status r이면 stdIdx + 1 ~ 끝까지 배열 복사해 리턴
        return new String[0];
    }
}
