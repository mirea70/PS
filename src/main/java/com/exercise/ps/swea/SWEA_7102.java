package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_7102 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Map<Integer, Integer> sum_frequencies = new HashMap<>();
			int max_frequency = 0;
			List<Integer> ans_list = new ArrayList<>(); 
			// n, m 이중 for문
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
			// Map에 두 숫자의 합을 key로 빈도수를 갱신한다.
					int sum = i + j;
					sum_frequencies.put(sum, sum_frequencies.getOrDefault(sum, 0)+1);
				}
			}
			// 이중 순회 끝
			// map을 순회하며 value의 최대값을 구한다.
			for(int val : sum_frequencies.values()) {
				if(val > max_frequency)
					max_frequency = val;
			}
			// map을 다시 순회하며 value가 최대값인 key를 리스트에 담는다.
			for(Map.Entry<Integer, Integer> entry : sum_frequencies.entrySet()) {
				if(entry.getValue() == max_frequency)
					ans_list.add(entry.getKey());
			}
			// 리스트 오름차순 정렬
			Collections.sort(ans_list);
			// 리스트를 순회하며 출력한다.
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int ans : ans_list) {
				sb.append(ans).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			System.out.print(sb);
		}
	}
}
