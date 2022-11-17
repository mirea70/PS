package com.exercise.ps.Programmers;

import java.util.Arrays;

public class hash_3 {
    public static void main(String[] args) {
        String[] arr = new String[3];
        String ab = "abc";
        Arrays.sort(arr);
        ab.startsWith("a");
    }
}

class hash_3_Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 완전탐색을 안하는 방법..
        // 사전순으로 정렬한다.
        Arrays.sort(phone_book);
        // 정렬하고나서, 만약 해당 번호가 접두사인 번호가 존재한다면, 그 번호 바로 뒤에 무조건 하나 있다.
        // 배열을 순회하며 바로 뒤에 것이 이번호로 시작하는지 확인하고, 시작한다면 answer = false
        for(int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) answer = false;
        }
        return answer;
    }
}