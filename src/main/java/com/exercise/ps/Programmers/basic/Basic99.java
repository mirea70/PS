package com.exercise.ps.Programmers.basic;

public class Basic99 {
    public int solution(String[] order) {
        int price = 0;
        // order 순회
        for(String menu : order) {
            // 문자열에 cafelatte 가 포함되는 경우 : 5000원
            if(menu.contains("cafelatte"))
                price += 5000;
            // 아닌 경우 : 4500원
            else
                price += 4500;
        }
        // 순회 끝
        return price;
    }
}
