package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MR12791 {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<String>> data = new HashMap<>();
        String initDataStr = "1967 DavidBowie\n" +
                "1969 SpaceOddity\n" +
                "1970 TheManWhoSoldTheWorld\n" +
                "1971 HunkyDory\n" +
                "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars\n" +
                "1973 AladdinSane\n" +
                "1973 PinUps\n" +
                "1974 DiamondDogs\n" +
                "1975 YoungAmericans\n" +
                "1976 StationToStation\n" +
                "1977 Low\n" +
                "1977 Heroes\n" +
                "1979 Lodger\n" +
                "1980 ScaryMonstersAndSuperCreeps\n" +
                "1983 LetsDance\n" +
                "1984 Tonight\n" +
                "1987 NeverLetMeDown\n" +
                "1993 BlackTieWhiteNoise\n" +
                "1995 1.Outside\n" +
                "1997 Earthling\n" +
                "1999 Hours\n" +
                "2002 Heathen\n" +
                "2003 Reality\n" +
                "2013 TheNextDay\n" +
                "2016 BlackStar";

        initData(data, initDataStr);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder totalSb = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        while(N--> 0) {
            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int i=s; i<=e; i++) {
                if(data.containsKey(i)) {
                    for(String name : data.get(i)) {
                        cnt++;
                        sb.append(i).append(" ").append(name).append("\n");
                    }
                }
            }
            totalSb.append(cnt).append("\n").append(sb);
        }

        totalSb.setLength(totalSb.length()-1);
        System.out.print(totalSb);
    }

    private static void initData(Map<Integer, List<String>> data, String initDataStr) {
        StringTokenizer st = new StringTokenizer(initDataStr, "\n");
        while (st.hasMoreTokens()) {
            String line = st.nextToken();
            String[] info = line.split(" ");
            int year = Integer.parseInt(info[0]);
            List<String> list = data.getOrDefault(year, new ArrayList<>());
            list.add(info[1]);
            data.put(year, list);
        }
    }
}
