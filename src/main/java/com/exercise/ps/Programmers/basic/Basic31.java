package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic31 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];

        int[] head = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] tail = Arrays.copyOfRange(num_list, 0, n);

        for(int i=0; i<head.length; i++)
            answer[i] = head[i];

        for(int i=head.length; i<head.length+tail.length; i++)
            answer[i] = tail[i-head.length];

        return answer;
    }
}
