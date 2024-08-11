package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2635 {

    private static List<Integer> ans_list = new ArrayList<>();
    private static int max_len = 0;

    public static void main(String[] args) throws IOException {
        // 첫번째 수 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        // 두번째 수를 결정하는 순회
        for(int second = first; second>=1; second--) {
            // 수 만들기 함수에 넣기
            makeNumbers(first, second);
        }
        // 순회 끝
        // ans_list 출력
        StringBuilder sb = new StringBuilder();
        sb.append(max_len).append("\n");
        for(int num : ans_list)
            sb.append(num).append(" ");
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    private static void makeNumbers(int first, int second) {
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        int num = first - second;
        while(num >= 0) {
            // 현재 num을 리스트에 넣기
            list.add(num);
            // 새 num으로 변경
            int len = list.size();
            num = list.get(len-2) - list.get(len-1);
        }
        // 만약 list 길이가 최대 길이보다 크다면
        if(list.size() > max_len) {
            // 최대 길이, list 갱신
            max_len = list.size();
            ans_list = list;
        }

//        System.out.println(list.toString());
    }
}
