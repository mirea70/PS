package main.java.com.exercise.ps.Programmers.kakao;

import java.util.*;

class MostPresentPerson {
    public int MostPresentPerson(String[] friends, String[] gifts) {
        int answer = 0;
        // 이름 key인 map <- 선물지수
        // int[][] 누가 어디에 줬는지 저장
        // frends 만큼 2차원배열 생성
        // 순회 끝
        // gifts 순회
        Map<String, Integer> scores = new HashMap<>();
        int[][] giveInfos = new int[friends.length][friends.length];
        List<String> names = new ArrayList<>();
        for(String friend : friends)
            names.add(friend);
        for(String gift : gifts) {
            String[] input = gift.split(" ");
            scores.put(input[0], scores.getOrDefault(input[0], 0)+1);
            scores.put(input[1], scores.getOrDefault(input[1], 0)-1);
            giveInfos[names.lastIndexOf(input[0])][names.lastIndexOf(input[1])]++;
        }

        int[] nexts = new int[friends.length];

        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                if(i != j) {
                    int give = giveInfos[i][j];
                    int get = giveInfos[j][i];

                    if(give > get) {
                        nexts[i]++;
                    }
                    else if(give == get) {
                        if(scores.getOrDefault(friends[i], 0) > scores.getOrDefault(friends[j], 0))
                            nexts[i]++;
                    }
                }
            }
        }
        Integer[] arr = Arrays.stream(nexts).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());
        answer = arr[0];

        return answer;
    }
}
