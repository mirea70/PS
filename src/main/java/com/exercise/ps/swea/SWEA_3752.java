package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SWEA_3752 {

    private static Set<Integer> scoreSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // ox 재귀 돌아서 depth n일 때 총합을 set에 담는다
        // set의 길이가 정답

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            scoreSet.add(0);
            for(int val : arr)
                addSum(val);

            System.out.printf("#%d %d%n", t, scoreSet.size());
            scoreSet.clear();
        }
    }

    private static void addSum(int num) {
        // 이전까지 set에 담겨있던 set을 순회하며
        Set<Integer> tmpSet = new HashSet<>();
        tmpSet.addAll(scoreSet);
        // 해당 set 내부 값 + num을 set에 추가
        for(int val : tmpSet) {
            scoreSet.add(val + num);
        }
    }
}
