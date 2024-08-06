package main.java.com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.util.stream.Collectors;

public class Q1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        // Comparator를 만든다
        Comparator<Map.Entry<String,Integer>> comparator = (o1, o2) -> {
            if(o1.getValue().intValue() != o2.getValue().intValue()) {
                return o2.getValue() - o1.getValue();
            }
            else
                return o1.getKey().compareTo(o2.getKey());
        };

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String title = sc.nextLine();
            int v = map.getOrDefault(title, 0);
            map.put(title, v+1);
        }
        List<Map.Entry<String,Integer>> list = map.entrySet().stream().sorted(comparator).collect(Collectors.toList());

        // 가장 앞의 값 출력
        System.out.print(list.get(0).getKey());
    }
}
