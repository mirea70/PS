package main.java.com.exercise.ps.Programmers.greedy;

import java.util.*;

public class greedy_4 {
    public static void main(String[] args) {

    }
}

class greedy_4_Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        // people을 리스트에 넣는다
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : people) list.add(i);
        // 리스트를 오름차순 정렬
        Collections.sort(list);
        // 다시 덱에 넣는다
        ArrayDeque<Integer> dq = new ArrayDeque<>(50005);
        for(int l : list) dq.add(l);
        // 덱이 빌 때 까지 반복
        while(!dq.isEmpty()){
            // 맨뒤를 빼고 짝이 있는지 확인(맨앞)
            // 맨앞과 더했을 떄 limit 보다 작다면 맨앞도 지워주기
            // boat++
            int last = dq.pollLast();
            if(!dq.isEmpty() && last + dq.peekFirst() <= limit) dq.pollFirst();

            boat++;
            // 바깥 반복문 종료
        }
        return boat;
    }
}
