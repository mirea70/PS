package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20955 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            String normal = br.readLine();
            String target = br.readLine();

            // target을 규칙에 따라 지워간다 (되돌림)
            // target - nomal 길이만큼 수행 후
            // 둘이 같다면 가능한 것임
            int dif = target.length() - normal.length();
            StringBuilder E = new StringBuilder(target);
            for(int i=0; i<dif; i++) {
                // 마지막이 X라면 X를 지운다
                if(E.charAt(E.length()-1) == 'X') E.deleteCharAt(E.length()-1);
                // 마지막이 Y라면 Y를 지우고, 리버스
                else if(E.charAt(E.length()-1) == 'Y') {
                    E.deleteCharAt(E.length()-1);
                    E.reverse();
                }
            }

            System.out.println(E.toString().equals(normal) ? "Yes" : "No");
        }
    }
}
