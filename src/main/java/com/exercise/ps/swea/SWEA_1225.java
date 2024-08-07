package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++)
				q.add(Integer.parseInt(st.nextToken()));
			out: while(true) {
				// 한 사이클
				boolean flag = false;
				for(int i=1; i<=5; i++) {
					// 맨 앞 수 뽑기
					int val = q.poll();
					// i만큼 빼기
					val -= i;
					// 빼고난 수가 0보다 작을 경우
					if(val <= 0) {
						val = 0;
						// 종료 플래그 true
						flag = true;
					}
					q.add(val);
					if(flag) break out;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int num : q)
				sb.append(num).append(" ");
			sb.setLength(sb.length()-1);
			
			System.out.println(sb);
		}
	}
}
