package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MR25629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 주어진 숫자들을 순회하며 홀수와 짝수를 각각 리스트에 저장
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for(int num : arr) {
            if(num % 2 != 0) {
                oddList.add(num);
            }
            else {
                evenList.add(num);
            }
        }
        // 각 리스트를 오름차순 정렬
        Collections.sort(oddList);
        Collections.sort(evenList);
        // 홀짝수열 가능 판별에 따라 숫자 출력
        System.out.print(isValid(N, oddList, evenList) ? 1 : 0);
    }

    private static boolean isValid(int N, List<Integer> oddList, List<Integer> evenList) {
        int oddLen = oddList.size();
        int evenLen = evenList.size();
        // 홀수 포인터, 짝수 포인터를 올려나가며 N번까지 채워나간다.
        int pointer = 0;
        int oddPointer = 0;
        int evenPointer = 0;
        while (pointer < N) {
            // 현재 포인터 + 1의 홀짝여부에 따라 포인터값을 상승시켜나간다.
            if((pointer + 1) % 2 != 0) {
                if(oddPointer >= oddLen) {
                    return false;
                }
                oddPointer++;
            }
            else {
                if(evenPointer >= evenLen) {
                    return false;
                }
                evenPointer++;
            }
            pointer++;
        }
        return true;
    }
}
