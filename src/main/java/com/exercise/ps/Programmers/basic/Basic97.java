package com.exercise.ps.Programmers.basic;

import java.util.Scanner;

public class Basic97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        for(int i=0; i<n; i++)
            System.out.print(str);
    }
}
