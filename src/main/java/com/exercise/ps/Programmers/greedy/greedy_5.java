package main.java.com.exercise.ps.Programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class greedy_5 {
}
class greedy_5_Solution {
    // 노드 사이의 연결 처리를 저장할 행렬 생성
    int[][] linked;
    // 연결 수
    int link_cnt = 0;

    public int solution(int n, int[][] costs) {
        int pay = 0;
        linked = new int[n][n];

        // 2번 인덱스 기준으로 costs를 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[2] - a2[2];
            }
        });

        // costs를 순회
        for(int i=0; i<costs.length;i++){
            // 제시된 노드끼리 연결 처리
            int result = linking(costs[i][0], costs[i][1]);
            // 연결에 성공했으면 비용 증가
            if(result == 1) pay += costs[i][2];
            // 연결 수 확인 : 연결 수가 n(n-1)/2 라면 반복문 종료
            if(link_cnt == n * (n - 1) / 2) break;
        }
        return pay;
    }
    // 연결 처리 함수
    private int linking(int node1, int node2) {
        // 두 노드가 이미 연결되있는지 확인
        if(linked[node1][node2] == 1 || linked[node2][node1] == 1) return -1;
        // node1과 node2의 간접연결
        // linked[node1]을 순회
        for(int j=0; j< linked[node1].length; j++){
            // node1과 연결되있는 노드와
            if(linked[node1][j] ==1) {
                // node2가 연결되있지 않다면 연결 처리
                if(linked[j][node2] != 1){
                    linked[j][node2] = 1;
                    linked[node2][j] = 1;
                    link_cnt++;
                }
                // node2을 순회하며 node2과 연결된 노드도 j와의 연결 체크 후 연결처리
                for(int l=0; l< linked[node2].length; l++) {
                    if(linked[node1][l] == 1 && linked[j][l] != 1) {
                        linked[j][l] = 1;
                        linked[l][j] = 1;
                        link_cnt++;
                    }
                }
            }
            // 순회 끝
        }
        // linked[node2]을 순회
        for(int k=0; k< linked[node2].length; k++){
            // node2과 연결되있는 노드와
            if(linked[node2][k] ==1) {
                // node1가 연결되있지 않다면 연결 처리
                if(linked[k][node1] != 1){
                    linked[k][node1] = 1;
                    linked[node1][k] = 1;
                    link_cnt++;
                }
                // node1을 순회하며 node1과 연결된 노드도 k와의 연결 체크 후 연결처리
                for(int l=0; l< linked[node1].length; l++) {
                    if(linked[node1][l] == 1 && linked[k][l] != 1) {
                        linked[k][l] = 1;
                        linked[l][k] = 1;
                        link_cnt++;
                    }
                }
            }
            // 순회 끝
        }
        // node1과 node2를 직접연결
        linked[node1][node2] = 1;
        linked[node2][node1] = 1;
        link_cnt++;
        return 1;
    }
}
