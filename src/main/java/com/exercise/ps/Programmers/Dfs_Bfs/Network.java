package com.exercise.ps.Programmers.Dfs_Bfs;

public class Network {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        // n 크기의 네트워크 방문 배열 생성
        boolean[] visited = new boolean[n];
        // 0번 노드부터 방문하지 않았을 경우에만 방문 배열 채우기 시작
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                // 채우기 시작할때 네트워크 카운트 상승
                cnt++;
                fill(visited, computers, i);
            }
        }
        return cnt;
    }

    private void fill(boolean[] visited, int[][] computers, int node) {
        // 자신의 노드 번호 방문체크
        visited[node] = true;
        // computers 배열을 이용해 해당 노드를 기준으로
        // 자신이 아닌 노드행이 아직 방문 전이면서, 1일 경우 dfs를 돈다.
        for(int i=0; i<computers.length; i++) {
            if(i != node && !visited[i] && computers[node][i] == 1)
                fill(visited, computers, i);
        }
    }
}
