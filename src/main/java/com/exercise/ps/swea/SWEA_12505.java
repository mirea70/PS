package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_12505 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				q.add(Integer.parseInt(st.nextToken()));
			for(int i=0; i<m; i++) {
				q.add(q.poll());
			}
			System.out.printf("#%d %d%n", t, q.poll());
		}
	}
}
