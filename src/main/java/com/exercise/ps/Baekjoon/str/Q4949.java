package com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q4949 {

    static Stack<String> stack = new Stack<>();
//    static Stack<String> l_stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            stack.clear();
//            l_stack.clear();
            System.out.println(is_balance(str));
        }
        br.close();
    }

    private static String is_balance(String str) {
        for(String s : str.split("")) {
            // 스택에 (, [ 를 만나면 넣는다
            if(s.equals("(")) stack.add(s);
            else if(s.equals("[")) stack.add(s);
            // ), ] 일경우
                // (, [ 가 있는지 찾는다
                // 없으면 return false
            else if(s.equals(")")) {
                if(stack.isEmpty()) return "no";
                if(stack.peek().equals("(")) stack.pop();
                else return "no";
            }
            else if(s.equals("]")) {
                if(stack.isEmpty()) return "no";
                if(stack.peek().equals("[")) stack.pop();
                else return "no";
            }
        }
//        System.out.println(s_stack.toString());
//        System.out.println(l_stack.toString());
        // 반목문이 끝나고 스택이 비어있으면 true, 아니면 false
        if(stack.isEmpty()) return "yes";
        return "no";
    }
}
