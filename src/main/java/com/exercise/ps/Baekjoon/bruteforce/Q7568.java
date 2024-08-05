package main.java.com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> gather = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] one = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            gather.add(one);
        }
        // 집단 배열을 순회한다
        Iterator<int[]> it = gather.iterator();
        int outIdx = 0;
        int inIdx = 0;
        int[] sum_gather = new int[N];

        while(it.hasNext()) {
            int[] target = it.next();
            Iterator<int[]> it2 = gather.iterator();
            // 내부에서 다시 순회하며, 자신보다 덩치가 크면 그 수를 센다.
            while(it2.hasNext()) {
                if(inIdx != outIdx) {
                    int[] source = it2.next();
                    if(source[0] > target[0] && source[1] > target[1]) {
                        sum_gather[outIdx]++;
                    }
                }
                inIdx++;
                // 내부 순회 끝
            }
            outIdx++;
            // 배열의 해당 인덱스에 갯수 + 1 을 저장
            // 순회 끝
        }
        // 출력 배열 순회 -> 공백 더해서 출력
        for(int sum : sum_gather) {
            System.out.print((sum + 1) + " ");
        }
    }
}
