package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	// 배열 입력
        	int[] prices = new int[n];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++)
        		prices[i] = Integer.parseInt(st.nextToken());
        	// 배열 순회
        	// 해당 날짜 무조건 구매
        	// 팔 것인지 결정한다.
        	// - 
        }
    }
}
