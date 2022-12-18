package com.exercise.ps.Programmers.Dfs_Bfs;

import java.lang.reflect.Array;
import java.util.*;

public class Dfs_Bfs_5 {
    public static void main(String[] args) {
        Dfs_Bfs_5_Solution d5 = new Dfs_Bfs_5_Solution();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"},{"B", "ICN"}};
//        String[][] tickets = {{"ICN", "A"}, {"A", "B"},{"A", "C"},{"B","A"},{"C","A"}};
        System.out.println("d5.solution(tickets) = " + Arrays.toString(d5.solution(tickets)));
    }
}
class Dfs_Bfs_5_Solution {
    String[][] tickets;
    // 방문 체크 배열
    boolean[] chk;
    // 경로들을 담은 리스트
    ArrayList<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        chk = new boolean[tickets.length];
        dfs(0, "ICN","ICN");
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    private void dfs(int depth, String now, String path) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }
        for (int i = 0; i < chk.length; i++) {
            if(!chk[i] && now.equals(tickets[i][0])) {
                chk[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1]);
                chk[i] = false;
            }
        }
    }
}