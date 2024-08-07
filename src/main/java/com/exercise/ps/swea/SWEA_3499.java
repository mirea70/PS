package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] cards = new String[n];
			for(int i=0; i<n; i++)
				cards[i] = st.nextToken();
			// 절반 인덱스 = mid.
			int mid = (n-1)/2;
			// 해당 인덱스까지 left, 그다음 인덱스부터 끝까지가 right
			int left = 0;
			int right = mid + 1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			// left <= mid, right < n 일 동안 반복
			while(left <= mid || right < n) {
				// 교차로 출력 스트링빌더에 담는다.(left 먼저)
				sb.append(cards[left]).append(" ");
				// 만약 right는 이미 초과라면 행위 x
				if(right < n) sb.append(cards[right]).append(" ");
				// left, right 올리기
				left++;
				right++;
			}
			sb.setLength(sb.length()-1);
			// 반복 끝
			// 스트링 빌더 출력
			System.out.println(sb);
		}
	}
}
