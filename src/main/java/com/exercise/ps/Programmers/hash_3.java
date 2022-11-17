package com.exercise.ps.Programmers;

import java.util.Arrays;
import java.util.HashSet;

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

    public boolean solution2(String[] phone_book) {
        // 해시셋에 각 번호를 넣는다
        // 각 번호에 대해, 번호를 순회하며, 0번째 부터 잘라 한자리씩 늘려 임시 String을 만들고 그 자체가 값인지 검증한다.
        // 즉, 한 단어만 꺼내서, 그단어에 포함된 것들로 시작하는 것들이 있는지 살펴보는 것이다.
        // 즉 n번만 순회하게되어 테스트 통과가 가능
        HashSet<String> set = new HashSet<>();
        for(String str : phone_book) {
            set.add(str);
        }

        for(String s : set) {
            for (int i = 1; i < s.length(); i++) {
                if(set.contains(s.substring(0, i))) return false;
            }
        }
        return true;
    }
}

