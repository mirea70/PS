package com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class MeetingRoom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        // n -> 회의실 별 9~18 빈 공간 생성 map에 boolean[19]
        Map<String, boolean[]> meetingRooms = new HashMap<>();
        for (int i=0; i<n; i++) {
            String key = br.readLine();
            meetingRooms.put(key, new boolean[19]);
            meetingRooms.get(key)[18] = true;
        }
        // m -> 회의실 점유
        for(int i=0; i<m; i++) {
            String[] input2 = br.readLine().split(" ");
            int s = Integer.parseInt(input2[1]);
            int t = Integer.parseInt(input2[2]);
            for(int j=s; j<t; j++) {
                meetingRooms.get(input2[0])[j] = true;
            }
        }

        Set<String> roomNames = meetingRooms.keySet();

        Map<String, List<String>> timeLists = new HashMap<>();

        // 회의실 별 09 ~ 18시까지 순회하며
        for(String room : roomNames) {
            // 가능한 시각 있으면 리스트에 담아 map에 넣기
            timeLists.put(room, new ArrayList<String>());
            boolean[] times = meetingRooms.get(room);
            int start = -1;
            int end = -1;
            for(int i=9; i<=18; i++) {
                if(start == -1) {
                    if(!times[i]) {
                        start = i;
                    }
                }
                else {
                    if(times[i]) {
                        // end = i != 17 ? i : 18;
                        end = i;
                        timeLists.get(room).add(String.format("%2s", start).replace(" ", "0") + "-" + String.format("%2s", end).replace(" ", "0"));
                        start = -1;
                        end = -1;
                    }
                }
            }
        }
        // 순회 끝
        // map의 key값 불러와서 리스트로 변환 -> 오름차순 정렬
        List<String> keyList = new ArrayList<>(roomNames);
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        // key 리스트 순회
        for(String key : keyList) {
            // 리스트에 따라 답 출력
            sb.append("Room ").append(key).append(": ").append("\n");
            List<String> list = timeLists.get(key);
            if(list.size() > 0) {
                sb.append(list.size()).append(" available: ").append("\n");
                for(String l : list)
                    sb.append(l).append("\n");
            }
            else {
                sb.append("Not available").append("\n");
            }
            sb.append("-----").append("\n");
        }
        sb.setLength(sb.length()-6);
        System.out.print(sb.toString());
    }
}
