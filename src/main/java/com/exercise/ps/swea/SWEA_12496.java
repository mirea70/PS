package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_12496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// 문자열을 입력받으면서
			char[] arr = br.readLine().toCharArray(); 
			// 스택에 담기를 시도한다.
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<arr.length; i++) {
				char val = arr[i];
			// 스택이 비어있지 않으면서, top 값이 넣을 값과 같다면 들어있던 값을 pop
				if(!stack.isEmpty() && stack.peek().equals(val))
					stack.pop();
				// 그게 아니라면 그냥 담기
				else stack.add(val);
			}
			// 담기 시도가 끝난 후
			// 스택의 크기를 출력
			System.out.printf("#%d %d%n", t, stack.size());
		}
	}
}
