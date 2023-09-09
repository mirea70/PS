package com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q5430 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<T; i++) {
            String[] commands = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replaceAll("\\[", "").replaceAll("]", "").split(",");
            for(String s : arr) {
                if(!s.equals(""))
                    q.add(Integer.parseInt(s));
            }
            executeMethod(commands, q);
        }
        System.out.println(sb.toString());
    }

    private static void executeMethod(String[] commands, Deque<Integer> q) {

        boolean is_right = false;

        for(String command : commands) {
            if(command.equals("R")) {
                is_right = !is_right;
            }
            else {
                if(q.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }
                if(!is_right) q.pollFirst();
                else q.pollLast();
            }
        }
        makePrintString(q, is_right);
        q.clear();

    }

    private static void makePrintString(Deque<Integer> q, boolean is_right) {
        sb.append("[");
        if(q.size() > 0) {
            if(!is_right) {
                sb.append(q.pollFirst());

                while(!q.isEmpty()) {
                    sb.append(",").append(q.pollFirst());
                }
            }
            else {
                sb.append(q.pollLast());

                while(!q.isEmpty()) {
                    sb.append(",").append(q.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }
}
