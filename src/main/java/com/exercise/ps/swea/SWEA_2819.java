package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_2819 {

    private static Set<String> set = new HashSet<>();
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            map = new char[4][4];
            // 맵그리기
            for(int i=0; i<4; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<4; j++) {
                    map[i][j] = input[j].charAt(0);
                }
            }

            // 맵 순회
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    // 6번 이동하는 것 시도 -> 6번 이동 완료 후 Set에 저장
//					System.out.println("(" + i + "," + j + ") = " + map[i][j] );
                    dfs(i,j, Character.toString(map[i][j]));
                }
            }
            // set의 길이 출력
            System.out.printf("#%d %d%n", t, set.size());
            set.clear();
        }
    }

    private static void dfs(int y, int x, String str) {
        // str 길이 == 7이면 set에 추가, 리턴
        if(str.length() == 7) {
            set.add(str);
            return;
        }
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 4 || ny <0 || nx >=4 || nx <0) continue;
            dfs(ny, nx, str + map[ny][nx]);
        }
    }
}
