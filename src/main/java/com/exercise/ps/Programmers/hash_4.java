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
        int answer = 0;
        // 종류 별로 하나씩만 입을 수 있다.
        // clothes를 순회하며, 각 요소안의 1번째 인덱스(옷 종류)를 키값으로 HashMap에 넣는다
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // 옷 조합을 체크할 map
        HashMap<String, String> chk_map = new HashMap<>();

        for(String[] cloth : clothes) {
            // 넣을때 만약 해당 키값의 값이 존재하면, 그 값을 불러와 추가하고, 없으면 새 리스트를 만들어 넣는다
            map.put(cloth[1], map.getOrDefault(cloth[1], new ArrayList<String>()));
            map.get(cloth[1]).add(cloth[0]);
        }
        Iterator<String> iterator = map.keySet().iterator();
        // HashMap을 순회하며,
        while(iterator.hasNext()) {
            String key = iterator.next();
            // 각 키의 value를 순회한다.
            ArrayList<String> values = map.get(key);

            // 각 key를 새로 순회
            for(String another_Key : map.keySet()) {
                // 순회중인 기존 key와 다른 key일 경우이면서,
                if(!key.equals(another_Key)) {
                    // 옷 조합 종류를 아직 사용안했거나, 이미 사용한 옷 종류 조합이 아닐 때만
                    if(chk_map.isEmpty() || ((chk_map.containsKey(another_Key) && !chk_map.get(another_Key).equals(key)) || (chk_map.containsKey(key) && !chk_map.get(key).equals(another_Key)))) {

                        ArrayList<String> another_Values = map.get(another_Key);
                        // 해당 옷조합을 사용했음을 체크
                        chk_map.put(key, another_Key);
                        for(String av : another_Values) {
                            // 조합 수 증가
                            for(String v : values) answer = answer + 1;
                        }
                    }
                } else {
                    // 다른 key가 아닐경우
                    for(String v : values) {
                        // 본래 key 이므로 해당 key value 값 각각에 대해 answer++
                        answer++;
                    }
                }
            }

        }
        // headgear : yellow_hat, green_turban
        // eyewear : blue_sunglasses, b
        // bb : c, d
        // 2
        //
        return answer;
    }
}