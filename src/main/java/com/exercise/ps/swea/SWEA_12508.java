package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_12508 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			// 대기열 큐에 배열을 담는다 (n크기까지만)
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<int[]> wait_q = new ArrayDeque<>();
			for(int i=1; i<=m; i++)
				wait_q.add(new int[] {i, Integer.parseInt(st.nextToken())});
			// 대기열 큐에서 n번만 활동 큐에 담는다.
			Queue<int[]> act_q = new ArrayDeque<>();
			for(int i=0; i<n; i++)
				act_q.add(wait_q.poll());

			int ans = -1;
			// 큐가 비지 않을때 동안 반복
			while(!act_q.isEmpty()) {
					int[] cul = act_q.poll();
					// 1번 자리 확인
					cul[1] /= 2;
					// 1번 자리가 0이면 (피자 다 녹았으면)
					if(cul[1] == 0) {
						if(!wait_q.isEmpty()) act_q.add(wait_q.poll());
						ans = cul[0];
					}
					// 0이 아니면 그냥 원래 값의 /2 값을 저장해서 밀어넣기
					else {
						act_q.add(new int[]{cul[0], cul[1]});
					}
				
			}
			// 해당 인덱스 번호 출력
			System.out.printf("#%d %d%n", t, ans);
		}
	}
}
