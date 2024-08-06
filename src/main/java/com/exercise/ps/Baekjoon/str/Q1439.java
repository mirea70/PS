package main.java.com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean open = true;
        int[] numCnt = new int[2];
        // 현재 보고있는 숫자 저장
        String cur = "";
        String[] arr = sc.nextLine().split("");
        // 0번 인덱스를 보는 숫자로 저장
        cur = arr[0];
        numCnt[Integer.parseInt(cur)]++;
        // 문자를 1번부터 순회
        for(int i=1; i<arr.length; i++) {
            // 보고있는 숫자와 다르다면
            if(!arr[i].equals(cur)) {
                // 현재 숫자 카운트를 증가시키고
                numCnt[Integer.parseInt(arr[i])]++;
                // 보고 있는 숫자를 바꾼다
                cur = arr[i];
            }
            // 순회 끝
        }
        // numCnt 중 작은 값 출력
        System.out.print(Math.min(numCnt[0], numCnt[1]));
    }
}
