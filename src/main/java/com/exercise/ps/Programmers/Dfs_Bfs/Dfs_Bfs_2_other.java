package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

public class Dfs_Bfs_2_other {
    public static void main(String[] args) {
        Dfs_Bfs_2_Solution bb = new Dfs_Bfs_2_Solution();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(bb.solution(n, computers));
    }
}
class Dfs_Bfs_2_other_Solution {
    int n;
    int[][] computers;
    int answer;
    // 컴퓨터 방문 체크 배열
    boolean[] visit;

    private void dfs(int node) {
        // computers[node] 길이만큼 순회한다
        for (int i = 0; i < computers[node].length; i++) {
            // 현재 노드 방문 체크
            visit[node] = true;
            // node가 1이 아니면서 i가 node와 다르고, 그 컴퓨터를 아직 방문하지 않았으면 재귀를 돈다
            if(i != node && computers[node][i] == 1 && !visit[i]) dfs(i);
        }
    }

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        answer = 0;
        int len = computers.length;

        visit = new boolean[len];

        // dfs를 computers 길이만큼 돈다(재귀 중 방문했던 컴퓨터는 방문 x)
        // dfs 한번 끝나면 answer++ : 연결이 끝났으니까
        for (int i = 0; i < len; i++) {
            if(!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}