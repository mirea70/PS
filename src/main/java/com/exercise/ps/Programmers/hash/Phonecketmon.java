package com.exercise.ps.Programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

public class Phonecketmon {
    public int solution(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        // nums를 순회하며, 그 값이 key, 빈도수가 value인 map에 담는다
        for(int k : nums) {
            map.put(k, map.getOrDefault(k, 0)+1);
        }
        // map 빈도수를 기준으로 key값의 오름차순 정렬
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();

        List<Map.Entry<Integer,Integer>> entryList = entrySet.stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // 정렬된 순서대로 2/N번만큼 set에 담는다
        for(int i=0; i<nums.length/2 && i< entryList.size(); i++) {
            set.add(entryList.get(i).getKey());
        }
        // 해당 set의 크기를 반환
        return set.size();
    }
}
