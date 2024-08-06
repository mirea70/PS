package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<int[]> queue = new ArrayDeque<>();
            for(int j=0; j<n; j++) {
                queue.add(new int[]{j+1, Integer.parseInt(st.nextToken())});
            }
            int res = -1;
            boolean isExtract;
            int cnt = 1;
            while(!queue.isEmpty()) {
                isExtract = true;
                int[] now = queue.poll();
                for(int[] doc : queue) {
                    if(doc[1] > now[1]) {
                        queue.add(now);
                        isExtract = false;
                        break;
                    }
                }
                if(isExtract) {
                    if(now[0] == m+1) res = cnt;
                    cnt++;
                }
            }
            System.out.println(res);
        }
    }
}
