package main.java.com.exercise.ps.swea;

import java.util.Scanner;

public class SWEA_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
        {
            // 숫자를 문자로 바꾼다.
            String s = String.valueOf(i);
            // 문자의 각자리수를 순회하며 3,6,9인지 개수를 센다.
            int cnt = 0;
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
                    cnt++;
            }
            // 개수 > 0 이면 그 개수만큼 - 담기
            if(cnt > 0) {
                for(int j=0; j<cnt; j++)
                    sb.append('-');
            }
            // 아니면 그냥 해당 숫자 담기
            else sb.append(s);
            // 공백 담기
            sb.append(' ');
        }
        // 마지막 공백 제거
        sb.setLength(sb.length()-1);
        // sb 출력
        System.out.print(sb.toString());
    }
}
