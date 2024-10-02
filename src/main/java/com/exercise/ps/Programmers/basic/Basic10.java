package com.exercise.ps.Programmers.basic;

public class Basic10 {
    public int[] solution(int[] arr) {

        int sum = 0;
        for(int num : arr)
            sum += num;

        int[] answer = new int[sum];
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            int a = arr[i];
            for(int j=0; j<a; j++) {
                answer[index] = a;
                index++;
            }
        }

        return answer;
    }
}
