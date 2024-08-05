package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomDeque deque = new CustomDeque();
        for(int i=0; i<n; i++) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];
            int x = arr.length == 2 ? Integer.parseInt(arr[1]) : 0;
            int res = command(deque, command, x);
            if(res != -2)
                System.out.println(res);
        }
    }

    private static int command(CustomDeque deque, String command, int x) {
        switch (command) {
            case "push_front": {
                deque.push_front(x);
                return -2;
            }
            case "push_back": {
                deque.push_back(x);
                return -2;
            }
            case "pop_front": {
                return deque.pop_front();
            }
            case "pop_back": {
                return deque.pop_back();
            }
            case "size": {
                return deque.size();
            }
            case "empty": {
                return deque.empty();
            }
            case "front": {
                return deque.front();
            }
            case "back": {
                return deque.back();
            }
        }
        return -2;
    }
}

class CustomDeque {
    List<Integer> list = new LinkedList<>();

    public void push_front(int x) {
        list.add(0, x);
    }

    public void push_back(int x) {
        list.add(x);
    }

    public int pop_front() {
        if(!list.isEmpty()) {
            int a = list.get(0);
            list.remove(0);
            return a;
        }
        else return -1;
    }

    public int pop_back() {
        if(!list.isEmpty()) {
            int a = list.get(list.size()-1);
            list.remove(list.size()-1);
            return a;
        }
        else return -1;
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        if(list.isEmpty()) return 1;
        else return 0;
    }

    public int front() {
        if(!list.isEmpty()) {
            int a = list.get(0);
            return a;
        }
        else return -1;
    }

    public int back() {
        if(!list.isEmpty()) {
            int a = list.get(list.size()-1);
            return a;
        }
        else return -1;
    }
}