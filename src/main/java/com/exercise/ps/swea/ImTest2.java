package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k_min = Integer.parseInt(st.nextToken());
			int k_max = Integer.parseInt(st.nextToken());
			
			int[] scores = new int[n];
			st = new StringTokenizer(br.readLine());
			
			int max = 0;
			int min = 101;
			for(int i=0; i<n; i++) {
				int val = Integer.parseInt(st.nextToken());
				scores[i] = val;
				if(val > max) max = val;
				if(val < min) min = val;
			}
			int t1 = min+1;
			int t2 = max-1;
			// t1 < t2 < 점수의 최댓값
			// 점수 최소값+1 < t1 < t2
			int min_dif = 101;
			for(t2 = 1; t2<100; t2++) {
				for(t1 = 1; t1<t2; t1++) {
					int result = getDif(k_min, k_max, t2, t1, scores);
					if(result != -1)
						min_dif = Math.min(result, min_dif);
				}
			}
			
			System.out.printf("#%d %d%n", t, min_dif == 101 ? -1 : min_dif);
		}
	}
		
	// 반별 최소인원, 최대인원 고려해 반을 나누고, 분반의 인원수의 최대, 최소 차이 반환하는 메서드
	private static int getDif(int k_min, int k_max, int t2, int t1, int[] scores) {
		int a = 0;
		int b = 0;
		int c = 0;
		
		for(int i=0; i<scores.length; i++) {
			if(scores[i] >= t2) {
				a++;
			}
			else if(scores[i] >= t1) {
				b++;
			}
			else c++;
		}
		
		int maxAb = Math.max(a, b);
		int max = Math.max(c, maxAb);
		
		int minAb = Math.min(a, b);
		int min = Math.min(c, minAb);
		
		if(a < k_min || b < k_min || c < k_min || a > k_max || b > k_max || c > k_max)
			return -1;
		
		return max - min;
	}
}
