package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            // 문자열 입력
            String str = br.readLine();
            // result no로 초기화
            String result = "NO";
            // 그 문자열 회문 체크
            if(isPalindrome(str)) {
                // 맞을 경우
                // 처음 00글자 회문 체크
                if(isPalindrome(str.substring(0, (str.length()-1)/2))) {
                    // 맞을 경우
                    // 마지막 00글자 회문 체크
                    // 모두 맞으면 yes
                    if(isPalindrome(str.substring((str.length()-1)/2 + 1))) {
                        result = "YES";
                    }
                }
            }
            // result 출력
            System.out.println("#" + t + " " + result);
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;

        while(left < right) {
            // 왼쪽 오른쪽 일치 체크
            // 일치하지 않으면 false 반환
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        // 일치하지 않은 경우가 한번도 없었으므로 true 반환
        return true;
    }
}
