package com.exercise.ps.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // 동일한 패턴인지 판단
        int len = s.length();

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        StringBuilder sSb = new StringBuilder();
        StringBuilder tSb = new StringBuilder();

        int sI = 0;
        int tI = 0;

        for(int i=0; i<len; i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);
            // 각각 map에 있는놈이면 그 num을 새 문자로 추가하고
            // 없는놈이면 인덱스를 카운트 한다음 그 인덱스로 추가한뒤, map에 넣는다.
            if(sMap.containsKey(sVal))
                sSb.append(sMap.get(sVal));
            else {
                sSb.append((char) sI);
                sMap.put(sVal, (char) sI++);
            }

            if(tMap.containsKey(tVal))
                tSb.append(tMap.get(tVal));
            else {
                tSb.append((char) tI);
                tMap.put(tVal, (char) tI++);
            }
        }
        // sSb와 tSb의 일치여부 반환
        return sSb.toString().equals(tSb.toString());
    }
}
