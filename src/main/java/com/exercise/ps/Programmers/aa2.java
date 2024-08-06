package main.java.com.exercise.ps.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class aa2 {
    public static void main(String[] args) {
        Solution2 s22 = new Solution2();
        int n = 9;
        int[][] wires = new int[][]{
                 {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
        };
        System.out.println("s22.solution(n, wires) = " + s22.solution(n, wires));
    }
}
class Solution2 {
    int[][] wires;
    int a = 0;
    int b = 0;
    int answer;
    boolean what = false;
    ArrayList<Integer> chk;

    public int solution(int n, int[][] wires) {
        this.wires = wires;
        answer = 100;
        chk = new ArrayList<>();
        for(int i=0;i< wires.length;i++) {
            // 끊은 원소(간선) 은 i, i 형태로 바꿈
            int[] temp = wires[i];
            wires[i][1] = wires[i][0];
            // 탐색 실시
            dfs(0);
            // a - b에 절댓값과 정답 비교 최신화, a, b 초기화
            answer = Math.min(Math.abs(a-b), answer);
            // 끊었던 간선 복구
            wires[i][1] = temp[1];
            wires[i][0] = temp[0];
        }
        // 리스트의 최솟값 출력
        return answer;
    }
    private void dfs(int index) {

        int x = wires[index][0];
        int y = wires[index][1];

        // chk에 없으면 노드 추가
        if(!chk.contains(x)) chk.add(x);
        if(!chk.contains(y)) chk.add(y);
        // i, i 형태를 만나면 그 때 까지의 노드개수 a에 저장, chk 초기화
        if(x == y) {
            if(index != wires.length - 1) a = chk.size();
            else {
                b = chk.size();
                chk.clear();
                return;
            }
//            Collections.sort(chk);
            HashSet set = new HashSet();
        }
        // 이어서 완전탐색 실시 : 완료되면 노드개수 b에 저장, chk 초기화
        if(index == wires.length - 1) {
            b = chk.size();
            chk.clear();
            return;
        }
        // 재귀
        dfs(index + 1);
    }
}