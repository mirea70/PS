package com.exercise.ps.Programmers.kakao;

import java.util.*;

public class WinterIntership2019_1 {
    public static void main(String[] args) {
        String data3 = "{{20,111},{111}}";
        //   20,111 , 111
        String data4= "{{123}}";

        System.out.println(Arrays.toString(solution(data4)));
    }

    public static int[] solution(String s) {
        // 집합을 길이순으로 정렬하여 저장
        Set<Integer>[] sets = new Set[500];

        int idx = 1;
        int len = s.length();
        int setCount = 0;
        while(idx < len-1) {
            char val = s.charAt(idx);
            if(val == '{') {
                Set<Integer> set = new HashSet<>();

                while(s.charAt(idx) != '}') {
                    idx++;
                    StringBuilder sb = new StringBuilder();
                    while(s.charAt(idx) != ',' && s.charAt(idx) != '}') {
                        val = s.charAt(idx);
                        sb.append(val);
                        idx++;
                    }
                    set.add(Integer.parseInt(sb.toString()));
                }

                sets[set.size()-1] = set;
                setCount++;
            }

            idx++;
        }
//        System.out.println(setCount);
//        System.out.println(sets[0].toString());

        // 0번부터 방문 Set 채워나간다. 이 때, 아직 방문하지 않은 수가 현재 인덱스 수
        int[] ans = new int[setCount];
        Set<Integer> visit = new HashSet<>();
        for(int i=0; i<setCount; i++) {
            Set<Integer> set = sets[i];
            for(int val : set) {
                if(!visit.contains(val)) {
                    visit.add(val);
                    ans[i] = val;
                    break;
                }
            }
        }

        return ans;
    }
}
