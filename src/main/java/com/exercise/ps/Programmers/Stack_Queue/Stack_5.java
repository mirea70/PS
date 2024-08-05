package main.java.com.exercise.ps.Programmers.Stack_Queue;

import java.util.*;

public class Stack_5 {
    public static void main(String[] args) {
        Stack_5_Solution s5 = new Stack_5_Solution();
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println("s5.solution(bridge_length, weight, truck_weights) = " + s5.solution(bridge_length, weight, truck_weights));
    }
}

class Stack_5_Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        // 1초에 한대 움직일수 있음
        // 트럭을 올리는 시간은 계산 X
        int sum = 0;
        Queue<Integer> wait = new LinkedList<>();
        Deque<Integer> bridge = new LinkedList<>();
        // truck_weights을 대기 큐에 넣는다

        for(int t : truck_weights) wait.add(t);
        // 시간 = bridge_length로 초기화
        time = bridge_length;
        int pick = 0;
        // 트럭 별 경과시간 관리 리스트
        List<Integer> time_manage = new ArrayList<>();
        // 다리 큐에 대기 큐 최대한 넣기
        while((!wait.isEmpty() && sum + wait.peek() <= weight) && bridge.size() + 1 <= bridge_length) {
            pick = wait.poll();
            sum += pick;
            bridge.add(pick);
            time_manage.add(bridge_length);
        }
        // 대기 큐가 비고 0만 존재할 때 까지 반복문 시작
        while(!(wait.isEmpty() && bridge.isEmpty())) {
            // 1초씩 늘린다.
            time++;
            for (int i = 0; i < time_manage.size(); i++) {
                time_manage.set(i, time_manage.get(i) + 1);
            }
            // 맨 앞이 시간경과 다 됬으면 다리 큐에서 하나 뺀다
            if(time_manage.get(0) >= bridge_length + 1) {
                sum -= bridge.poll();
                time_manage.remove(0);
            }
            // 대기 큐 탑 값 + 다리 큐 들어있는 값의 합 <= weight 이면서 다리 큐 사이즈 + 1 <= bridge_length일 동안 다리큐에 담기
            if((!wait.isEmpty() && sum + wait.peek() <= weight) && bridge.size() + 1 <= bridge_length) {
//                while ((!wait.isEmpty() && sum + wait.peek() <= weight) && bridge.size() + 1 <= bridge_length) {
                    pick = wait.poll();
                    sum += pick;
                    bridge.add(pick);
                    time_manage.add(1);
                }
            }
            // 반복 끝
//        }
        return time;
    }
}
