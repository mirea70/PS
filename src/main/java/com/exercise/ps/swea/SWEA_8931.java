package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			for(int i=0; i<k; i++) {
				int val = Integer.parseInt(br.readLine());
				if(val == 0) stack.pop();
				else stack.add(val);
			}
			int sum = 0;
			for(int num : stack)
				sum += num;
			System.out.printf("#%d %d%n", t, sum);
		}
	}
}
