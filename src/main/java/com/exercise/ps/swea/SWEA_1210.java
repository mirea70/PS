package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1210 {

    private static int ans = -1;
    private static boolean isFind = false;
    // 좌우 아래
    private static int[] dy = new int[]{0,0,1};
    private static int[] dx = new int[]{-1,1,0};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            // 테캐 번호 저장
            int T = Integer.parseInt(br.readLine());
            // 지도 저장
            map = new int[100][100];
            visited = new boolean[100][100];
            for(int i=0; i<100; i++) {
                int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                map[i] = arr;
            }
            // 0~100 순회
            for(int i=0; i<100; i++) {
                // 정답 찾았으면 순회 끝
                if(ans != -1) break;
                // 값==1이면 dfs
                if(map[0][i] == 1) {
                    dfs(0, i);
                    // 값 찾았으면 답 갱신
                    if(isFind) {
                        ans = i;
                        break;
                    }
                    visited = new boolean[100][100];
                }
            }
            // 정답 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(T).append(" ").append(ans);
            System.out.println(sb.toString());
            sb.setLength(0);
            ans = -1;
            isFind = false;
        }
    }

    private static void dfs(int y, int x) {
        // 방문체크
        visited[y][x] = true;
        // 정답 찾았으면 그냥 바로 리턴
        if(isFind) return;
        // 현재값 == 2라면 정답 갱신, 리턴
        if(map[y][x] == 2) {
            isFind = true;
            return;
        }
        // 좌, 우, 아래 방문 시도
        for(int i=0; i<3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 범위 넘은지 체크
            if(ny >= 100 || ny < 0 || nx >= 100 || nx < 0) continue;
            // 방문했는지 체크
            if(visited[ny][nx]) continue;
            // 좌, 우가 방문이 가능하다면 아래방향은 방문체크를 했다고 체크 -> 돌아왔을때 방문하지 않도록
            if(map[ny][nx] == 1 || map[ny][nx] == 2) {
                visited[y+1][x] = true;
                // 다음으로 dfs
                dfs(ny,nx);
            }
        }
    }
}
