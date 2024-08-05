package main.java.com.exercise.ps.swea;

import java.util.Scanner;

public class SWEA_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            // 주어진 문자열 순회
            // 첫문자 저장
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            char first = str.charAt(0);
            boolean isPattern = false;
            for(int i=1; i<str.length(); i++) {
                //    System.out.println(sb.toString());
                // 현재 문자가 첫문자와 동일하면
                char cur = str.charAt(i);
                if(cur == first)
                    // 마디인지 검증을 시도한다.
                    isPattern = check(str, i, sb.toString());
                // 검증이 통과되면 반복을 종료
                if(isPattern) break;
                // StringBuilder에 문자를 담아간다
                sb.append(cur);
            }
            // 마디길이 출력
            System.out.println("#" + test_case + " " + sb.length());
        }
    }

    private static boolean check(String str, int startIdx, String target) {
        int cnt = 0;
        // str을 startIdx부터 순회
        for(int i=startIdx; i<str.length(); i++){
            cnt++;
            // 순회수가 10번 넘어가면 종료
            if(cnt > 10) break;
            // 대상의 인덱스 % target의 길이 에 해당하는 값이 일치하는지 확인
            // 불일치할 시 false 리턴
            if(str.charAt(i) != str.charAt(i%target.length())) return false;
        }
        // 순회 끝
        // true 리턴
        return true;
    }
}
