package main.java.com.exercise.ps.Programmers.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SplitRoleCake {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        // topping 순회
        // 자르기 인덱스
        // 처음에 rightSet에 모두 담기
        // 맵에도 담는다
        for(int val : topping) {
            rightSet.add(val);
            rightMap.put(val, rightMap.getOrDefault(val, 0)+1);
        }

        for(int cutIdx = 0; cutIdx<topping.length-1; cutIdx++) {
            // System.out.println("left: " + leftSet.toString());
            // System.out.println("right: " + rightSet.toString());
            // cutIdx 을 왼쪽에 담기
            leftSet.add(topping[cutIdx]);
            // map에서 해당 값을 1줄이기
            rightMap.put(topping[cutIdx], rightMap.get(topping[cutIdx]) -1);
            // 그리고나서 map에서 그값이 1보다 작으면 cutIdx 을 오른쪽에서 빼기
            if(rightMap.get(topping[cutIdx]) < 1) {
                rightSet.remove(topping[cutIdx]);
            }

            // 왼, 오른쪽 Set의 크기 같으면 카운트
            if(leftSet.size() == rightSet.size())
                answer++;
        }
        // 순회 끝
        return answer;
    }
}


