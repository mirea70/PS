package com.exercise.ps.Programmers.basic;

public class Basic68 {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        String executer = arr[1];
        int b = Integer.parseInt(arr[2]);

        switch (executer) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
        }

        return -1;
    }
}
