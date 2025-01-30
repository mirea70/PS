package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CustomStack stack = new CustomStack();

        for(int i=0; i<N; i++) {
            int result = execute(stack, br.readLine());
            if(result != -2)
                System.out.println(result);
        }
    }

    public static int execute(CustomStack stack, String command) {
        switch (command) {
            case "pop": {
                return stack.pop();
            }
            case "size": {
                return stack.size();
            }
            case "empty": {
                return stack.empty();
            }
            case "top": {
                return stack.top();
            }
            default: {
                String[] tokens = command.split(" ");
                stack.push(Integer.parseInt(tokens[1]));

                return -2;
            }
        }
    }
}

class CustomStack {
    private final List<Integer> list;

    public CustomStack() {
        this.list = new ArrayList<>();
    }

    public void push(Integer X) {
        list.add(X);
    }

    public Integer pop() {
        if(list.isEmpty())
            return -1;
        int size = list.size();
        Integer res = list.get(size-1);
        list.remove(size-1);
        return res;
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        return list.isEmpty() ? 1 : 0;
    }

    public int top() {
        if(list.isEmpty())
            return -1;
        return list.get(list.size()-1);
    }
}