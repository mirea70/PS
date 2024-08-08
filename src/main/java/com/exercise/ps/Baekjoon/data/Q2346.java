package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Q2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		for(int i=0; i<n; i++)
			deque.add(new int[] {i+1, Integer.parseInt(st.nextToken())});
		// 정답 리스트
		StringBuilder sb = new StringBuilder();
		// 왼쪽 이동 : 가장 끝에 놈이 첫번째로 온다.
		// 오른쪽 이동 : 가장 첫놈이 가장 끝으로 간다.
		// 위 규칙에 맞춰 들어온 명령대로 풍선 터뜨리기 실행
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			sb.append(now[0]).append(" ");
			
			int command = now[1];
			// 커맨드가 양수 : 오른쪽 이동
			if(command > 0) {
				while(command-- > 1 && !deque.isEmpty()) {
					deque.addLast(deque.pollFirst());
				}
			}
			// 커맨드가 음수 : 왼쪽 이동
			else {
				while(command++ < 0 && !deque.isEmpty()) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
		//   -1 2 1
	}
}
