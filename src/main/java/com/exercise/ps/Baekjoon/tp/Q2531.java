package main.java.com.exercise.ps.Baekjoon.tp;

import java.util.*;
import java.io.*;

public class Q2531 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] num = new int[d+1];
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 최초 set에 0번부터 k번까지 담는다.
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<k; i++) {
            set.add(arr[i]);
            num[arr[i]]++;
        }
        // 그리고 쿠폰을 담는다
        set.add(c);
        // max 초기화
        int max = set.size();
        int kk = 0;
        // 배열을 1번 ~ N번까지 순회
        for(int i=1; i<N; i++, k++) {

            if(num[arr[i-1]] > 1) {
                num[arr[i-1]]--;
            }
            else set.remove(arr[i-1]);

            kk = k >=N ?  k % N : k;
            set.add(arr[kk]);
            num[arr[kk]]++;
            set.add(c);
            // max 갱신
            max = Math.max(max, set.size());
        }
        // max 출력
        System.out.println(max);
    }
}
