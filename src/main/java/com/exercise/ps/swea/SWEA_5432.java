package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T= Integer.parseInt(br.readLine());
		 for(int t=1; t<=T; t++) {
			 // 괄호 덩이 입력
			 char[] arr = br.readLine().toCharArray();
			 // 괄호 배열을 순회하며 스택에 담기 시도
			 Stack<Character> stack = new Stack<>();
			 int count = 0;
			 for(char c : arr) {
			 // ( 일경우
				 if(c == '(') {
			 // 스택에 담고, 실제 개수도 증가시킨다.
					 if(!stack.isEmpty() && stack.peek() == '(')
						 count++;
					 stack.add('(');
				 }
			 // ) 일 경우
				 else {
//					 count--;
			 // - 직전이 (일 경우 -> pop 후, 현재 스택의 크기만큼 개수 더하기
					 if(stack.peek() == '(') {
						 stack.pop();
						 count += stack.size();
					 }
			 // - 직전이 )일 경우 -> pop
					 else {
						 stack.pop();
					 }
				 }
			 }
			 // 스택 담는 반복 끝
			 // 실제 개수 출력
			 System.out.printf("#%d %d", t, count);
		 }
	}
}
