package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			// 원본 암호문 길이
			int n = Integer.parseInt(br.readLine());
			// 원본 암호문
			st = new StringTokenizer(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			for(int i=0; i<n; i++)
				list.add(st.nextToken());
			// 명령어 개수
			int command_len = Integer.parseInt(br.readLine());
			// 명령어 입력받으면서 실행
			st = new StringTokenizer(br.readLine(), "I");
			for(int j=0; j<command_len; j++) {
				String[] command = st.nextToken().split(" "); 
//				System.out.println(Arrays.toString(command));
				int x = Integer.parseInt(command[1]);
				int y = Integer.parseInt(command[2]);

				for(int k=0; k<y; k++)
					list.add(x + k, command[3+k]);
			}
			// 수정된 암호문 처음 10개 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++)
				sb.append(list.get(i)).append(" ");
			System.out.println(sb);
		}
	}
}

