package com.exercise.ps.Programmers.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KaKaoWinterInternship_1 {
    static Map<String, Friend> commonFriends;

    public int solution(String[] friends, String[] gifts) {
        // friends 순회 -> 친구 객체 초기화
        commonFriends = new HashMap<>();
        for(String name : friends) {
            commonFriends.put(name, new Friend(name));
        }
        // gifts 순회 -> 친구 객체별 선물지수, 선물 준 횟수 저장
        for(String gift : gifts) {
            String[] arr = gift.split(" ");
            String from = arr[0];
            String to = arr[1];
            Friend fromFriend = commonFriends.get(from);
            fromFriend.give(to);
        }
        // friends 순회 -> 각 친구 객체가 서로 다음달에 누가 선물받을지 결정 (방문여부 저장 : String 합친 형태)
        Set<String> visit = new HashSet<>();
        for(String name : friends) {
            Friend f1 = commonFriends.get(name);
            for(String to : friends) {
                if(name.equals(to)) continue;
                if(visit.contains(name + to)) continue;
                visit.add(name + to);
                visit.add(to + name);

                Friend f2 = commonFriends.get(to);
                int fromTo = f1.toFriendsCnt.getOrDefault(to, 0);
                int toFrom = f2.toFriendsCnt.getOrDefault(name, 0);
                if(fromTo != toFrom) {
                     if(fromTo > toFrom) {
                         f1.nextScore++;
                     }
                     else {
                         f2.nextScore++;
                     }
                }
                else {
                    if(f1.score > f2.score) {
                        f1.nextScore++;
                    }
                    else if(f2.score > f1.score) {
                        f2.nextScore++;
                    }
                }
            }
        }
        // friends 순회 -> 다음 달에 선물 가장 많이 받는 수 저장해서 리턴
        int max = 0;
        for(String name : friends) {
            max = Math.max(max, commonFriends.get(name).nextScore);
        }
        return max;
    }

    static class Friend {
        String name;
        int score;
        Map<String, Integer> toFriendsCnt;
        int nextScore;

        public Friend(String name) {
            this.name = name;
            score = 0;
            toFriendsCnt = new HashMap<>();
            nextScore = 0;
        }

        public void give(String name) {
            score++;
            toFriendsCnt.put(name, toFriendsCnt.getOrDefault(name, 0) + 1);
            Friend to = commonFriends.get(name);
            to.score--;
        }
    }
}

