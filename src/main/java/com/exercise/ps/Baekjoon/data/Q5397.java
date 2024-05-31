package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5397 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            char[] commands = br.readLine().toCharArray();
            for(char command : commands)
                command(command, left, right);
            while(!left.isEmpty()) right.add(left.pop());
            while(!right.isEmpty()) sb.append(right.pop());
            System.out.println(sb.toString());
            sb.setLength(0);
            left.clear();
            right.clear();
        }
    }

    private static void command(char command, Stack<Character> left, Stack<Character> right) {
        switch (command) {
            case '<' : {
                if(!left.isEmpty()) right.add(left.pop());
            }
            break;
            case '>' : {
                if(!right.isEmpty()) left.add(right.pop());
            }
            break;
            case '-' : {
                if(!left.isEmpty()) left.pop();
            }
            break;
            default  : {
                left.add(command);
            }
            break;
        }
    }
}
