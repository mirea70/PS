package com.exercise.ps.Programmers.basic;

public class Basic52 {
    public static void main(String[] args) {
        System.out.println("answer : " + solution("bc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"));
    }

    public static int solution(String str1, String str2) {

        int str1Len = str1.length();
        int str2Len = str2.length();
        int left = 0;
        // right를 str1Len에서 시작
        int right = str1Len;

        // 슬라이딩 윈도우
        outer: while(right <= str2Len) {
            // left ~ right 체크
            for(int i=left; i<right; i++) {
                // 다를 경우 left, right ++ 후 바깥 반복문 continue
                if(str1.charAt(i- left) != str2.charAt(i)) {
                    left++;
                    right++;
                    continue outer;
                }
            }

            // 같을 경우 1 리턴
            return 1;
        }

        return 0;
    }
}
