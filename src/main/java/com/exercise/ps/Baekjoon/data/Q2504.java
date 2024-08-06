package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int result = 0;
        int value = 1;
        Stack<Character> stack = new Stack<>();
        out: for(int i=0; i<str.length; i++) {
            switch (str[i]) {
                case '(' : {
                    value *= 2;
                    stack.push('(');
                }
                break;
                case '[' : {
                    value *= 3;
                    stack.push('[');
                }
                break;
                case ')' : {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break out;
                    }
                    else if(str[i-1] == '(') {
                        result += value;
                    }
                    stack.pop();
                    value /= 2;
                }
                break;
                case ']' : {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break out;
                    }
                    else if(str[i-1] == '[') {
                        result += value;
                    }
                    stack.pop();
                    value /= 3;
                }
                break;
            }
        }
        if(!stack.isEmpty()) result = 0;
        System.out.print(result);
    }
}
