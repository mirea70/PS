package main.java.com.exercise.ps.Programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

public class hash_5 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "sin" ,"classic", "classic", "classic", "sin", "pop"};
        int[] plays = {500, 600, 2000 ,800, 800, 800, 2000, 1500};
        hash_5_Solution h = new hash_5_Solution();
        System.out.println(Arrays.toString(h.solution(genres, plays)));
    }
}

class hash_5_Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, ArrayList<Integer>> musics = new HashMap<>();
        // genres와 plays를 순회하여 hashMap에 장르별로 분류하여 담는다
        for(int i = 0; i < genres.length; i++) {
            musics.put(genres[i] ,musics.getOrDefault(genres[i], new ArrayList<Integer>()));
//            if(!musics.containsKey(genres[i])) musics.put(genres[i], new ArrayList<>());
            musics.get(genres[i]).add(plays[i]);
        }
//        System.out.println("musics = " + musics.toString());
        // 장르 별 합계를 구한 뒤, map에 저장합니다.
        HashMap<String, Integer> sums = new HashMap<>();

        for(String genre : musics.keySet()) {
            int sum = musics.get(genre).stream().mapToInt(i -> i).sum();
            sums.put(genre, sum);
        }
        // map을 내림차순 정렬합니다.
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sums.entrySet());
//        System.out.println("entryList = " + entryList.toString());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        // 정렬된 map을 순회하며 각 장르의 노래 중, 재생 횟수가 높은 2개를 리스트에 담습니다
        List<Integer> answerList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entryList) {
            ArrayList<Integer> musicList = musics.get(entry.getKey());
            musicList.sort(Collections.reverseOrder());
//            System.out.println("musicList = " + musicList.toString());

            List<Integer> play_list = Arrays.stream(plays).boxed().collect(Collectors.toList());
            int cnt = 0;
            for (int i = 0; i < musicList.size(); i++) {
                if(cnt == 2) break;
                if(!answerList.contains(play_list.indexOf(musicList.get(i)))) {
                    answerList.add(play_list.indexOf(musicList.get(i)));
                    cnt++;
                }
                else {
                        answerList.add(play_list.lastIndexOf(musicList.get(i)));
                        cnt++;
                    }
                }

        }

//        System.out.println("answerList = " + answerList.toString());

        // 리스트를 배열로 바꾸어 answer에 넣고 반환합니다.
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
