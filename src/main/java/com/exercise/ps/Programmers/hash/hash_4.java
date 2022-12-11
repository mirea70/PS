package com.exercise.ps.Programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class hash_4 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String[][] arr = new String[][]
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = solution(arr);
        System.out.println(answer);

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        // 종류 별로 하나씩만 입을 수 있다.
        // clothes를 순회하며, 각 요소안의 1번째 인덱스(옷 종류)를 키값으로 HashMap에 넣는다
        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
            // 넣을때 만약 해당 키값의 값이 존재하면, 그 값을 불러와 추가해 1 더하고, 없으면 1
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        Iterator<Integer> iterator = map.values().iterator();
        // HashMap을 순회하며,
        while(iterator.hasNext()) {
            // 각 옷 종류의 개수 + 1을 기존 값에 곱해간다. + 1 은 각 옷을 입지 않은 경우를 포함한 것
            answer *= iterator.next().intValue() + 1;
        }
        // 아예 아무것도 입지 않은 경우의 수를 빼고 리턴
        return answer - 1;
    }
}