package com.exercise.ps.Programmers.basic;

public class Basic9 {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        if(len1 != len2) {
            if(len2 - len1 > 0)
                return -1;
            else
                return 1;
        }
        else {
            int sum1 = 0;
            for(int a : arr1)
                sum1 += a;
            int sum2 = 0;
            for(int b : arr2)
                sum2 += b;

            if(sum2 - sum1 > 0) return -1;
            else if(sum2 - sum1 == 0) return 0;
            else return 1;
        }
    }
}
