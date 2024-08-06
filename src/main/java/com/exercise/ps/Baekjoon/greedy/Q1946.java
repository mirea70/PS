package main.java.com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            List<int[]> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(arr);
            }
            int cnt = list.size();
            list.sort((o1,o2) -> o1[0] - o2[0]);
            for(int k=1; k<list.size(); k++) {
                for(int l=0; l<k; l++) {
                    if(list.get(k)[0] > list.get(l)[0] && list.get(k)[1] > list.get(l)[1]) {
                        cnt--;
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
