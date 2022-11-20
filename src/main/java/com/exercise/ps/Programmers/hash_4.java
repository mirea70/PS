package com.exercise.ps.Programmers;

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
        double answer = 0;
        // 종류 별로 하나씩만 입을 수 있다.
        // clothes를 순회하며, 각 요소안의 1번째 인덱스(옷 종류)를 키값으로 HashMap에 넣는다
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String[] cloth : clothes) {
            // 넣을때 만약 해당 키값의 값이 존재하면, 그 값을 불러와 추가하고, 없으면 새 리스트를 만들어 넣는다
            ArrayList<String> list = map.put(cloth[1], map.getOrDefault(cloth[1], new ArrayList<String>()));
            map.get(cloth[1]).add(cloth[0]);
        }
        Iterator<String> iterator = map.keySet().iterator();
        // HashMap을 순회하며,
        while(iterator.hasNext()) {
            String key = iterator.next();
            // 각 키의 value를 순회한다.
            ArrayList<String> values = map.get(key);
            for(String v : values) {
                // 각 value에 대해 answer + 1 후, 만약 다음 키 값이 존재하면 + 0.5
                answer = answer + 1;
                answer = answer + 0.5;
            }
        }
        // headgear : yellow_hat, green_turban
        // eyewear : blue_sunglasses
        // 1 + 0.5 + 1 + 0.5 + 1 + 0.5 + 0.5 = 5 => 자신 스스로가 아닐땐 0.5씩 더하면됨
        //
        return (int)answer;
    }
}