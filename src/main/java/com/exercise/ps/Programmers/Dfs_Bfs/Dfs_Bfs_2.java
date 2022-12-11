package com.exercise.ps.Programmers.Dfs_Bfs;

public class Dfs_Bfs_2 {
    public static void main(String[] args) {
        Dfs_Bfs_2_Solution bb = new Dfs_Bfs_2_Solution();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(bb.solution(n, computers));
    }
}
class Dfs_Bfs_2_Solution {
    int n;
    int[][] computers;
    int answer;
    // 컴퓨터 방문 체크 배열
    boolean[] visit;
    // 각 연결 체크 배열
    boolean[][] link_chk;
    // 노드 연결된사람 찾았다 배열
    boolean[] find;

    private void dfs(int node) {
        // 연결된 놈을 찾았다는 의미의 find
        find[node] = false;
        // 방문체크
        visit[node] = true;
        // computers[node][] 순회
        for (int i = 0; i < computers[node].length; i++) {
            // [i][i]
            if(i == node) {
                // i가 마지막이 아니면 그냥 패스
                if(i != computers[node].length - 1) continue;
            }

            // 1을 찾았음
            if(computers[node][i] == 1 && i != node) {
                // 연결체크 안되있으면 재귀 탄다
                if(!link_chk[node][i]) {
                    link_chk[node][i] = true;
                    link_chk[i][node] = true;
                    find[node] = true;
                    dfs(i);
                }
            }
            // i가 마지막이고 이 노드에서 1 못 찾았으면 answer++
            if (i == computers[node].length - 1 && !find[node]) {
                answer++;
                return;
            }
        }
    }

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        answer = 0;
        int len = computers.length;
        find = new boolean[len];

        visit = new boolean[len];
        link_chk = new boolean[len][len];

        // dfs를 computers 길이만큼 돈다(재귀 중 방문했던 컴퓨터는 방문 x)
        for (int i = 0; i < len; i++) {
            if(!visit[i]) dfs(i);
        }
        return answer;
    }
}