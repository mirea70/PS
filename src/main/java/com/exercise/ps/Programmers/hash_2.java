package com.exercise.ps.Programmers;

import java.util.HashMap;

public class hash_2 {
    public static void main(String[] args) {
    }
}
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // nums의 길이 / 2 = N
        int N = nums.length / 2;
        // 배열 순회
        HashMap<Integer, Integer> map = new HashMap<>();
        // HashMap에 각 숫자를 value 1로 담는다.
        for(int n : nums) {
            map.put(n, 1);
        }
        // 맵의 길이와 N 중 작은 값을 answer에 넣는다.
        answer = Math.min(map.size(), N);
        return answer;
    }
}