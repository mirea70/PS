package com.exercise.ps.Programmers.basic;

public class Basic55 {
    public int solution(String my_string, String target) {
        // 슬라이딩 윈도우
        // 좌측 인덱스
        int left = 0;
        // 오른측 인덱스 : target의 길이로 초기화
        int right = target.length();
        // 오른측 인덱스가 my_string 넘어가기 전까지 반복
        outer: while(right <= my_string.length()) {
            // - 좌측 ~ 우측 동일한지 체크
            for(int i=left; i<right; i++) {
                // - 동일하지 않다면 좌측 우측 인덱스 1증가, 바깥 반복문 continue
                if(my_string.charAt(i) != target.charAt(i-left)) {
                    left++;
                    right++;
                    continue outer;
                }
            }
            // 동일하다는 의미이므로, return 1
            return 1;
        }
        // 반복 끝
        // 0 리턴
        return 0;
    }
}
