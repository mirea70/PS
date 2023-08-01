package com.exercise.ps;

import java.util.ArrayList;
import java.util.Collections;

public class aa {
    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "011";
        System.out.println("s.solution(numbers) = " + s.solution(numbers));
    }
}
class Solution {
    String numbers;
    int answer = 0;
    boolean ck = false;
    String[] num_arr;
    int i = 0;
    // 체크 리스트
    ArrayList<Integer> chk_list;

    public int solution(String numbers) {
        this.numbers = numbers;
        this.num_arr = numbers.split("");

        // numbers를 String 배열로 만들어 순회
        // 각 문자별로 dfs 돈다
        chk_list = new ArrayList<>();

        dfs("", numbers);

        return answer;
    }
    private void dfs(String n, String others) {
        // n이 공백이 아니라면 소수 판별
        if(!n.equals("")) {
            if(chk(n)) answer++;
        }
        // 남은 숫자 중 한 개를 더해 새 조합 만들기
        for (int j = 0; j < others.length(); j++) {
            dfs(n + others.charAt(j), others.substring(0, j) + others.substring(j+1));
        }
    }
    private boolean chk(String str) {
        int n = Integer.parseInt(str);
        if(n==0 || n==1) return false;
        int lim = (int)Math.sqrt(n);
        for(int i = 2; i<=lim;i++){
            if(n % i == 0) return false;
        }
        if(chk_list.contains(n)) return false;
        else {
            chk_list.add(n);
            return true;
        }
    }
}
