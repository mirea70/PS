package com.exercise.ps.Programmers.basic;

import java.util.Scanner;

public class Basic51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String ans = "";
        if(n % 2 == 0)
            ans = " is even";
        else
            ans = " is odd";

        System.out.print(n + ans);
    }
}
