package main.java.com.exercise.ps.Baekjoon.str;

import java.util.*;

public class Q1254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int end = -1;

        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                end = isIng(arr, i, i+1);
            }
            else if(i > 0 && arr[i-1] == arr[i+1]) {
                end = isIng(arr, i-1, i+1);
            }
            if(end != -1) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        end = end != -1 ? end : arr.length-1;
        for(int i=0; i<end; i++) {
            sb.insert(0,arr[i]);
        }
        String answer = s + sb.toString();
        System.out.print(answer.length());
    }

    private static int isIng(char[] arr, int start, int end) {
        while(end < arr.length && start >= 0) {
            if(arr[start] != arr[end]) {
                return -1;
            }
            start--;
            end++;
        }
        if(end - 1 != arr.length - 1) return -1;
        return start + 1;
    }
}
