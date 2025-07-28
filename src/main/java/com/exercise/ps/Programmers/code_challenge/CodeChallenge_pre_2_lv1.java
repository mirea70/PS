package com.exercise.ps.Programmers.code_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeChallenge_pre_2_lv1 {

    public static void main(String[] args) {
        CodeChallenge_pre_2_lv1 test = new CodeChallenge_pre_2_lv1();
        System.out.println(test.solution(22, 6, 8));
    }

    public int solution(int n, int w, int num) {
        // 1. 상자를 차례대로 담는다.
        List<int[]> colList = new ArrayList<>();
        putBox(colList, n, w);

//        for(int i=colList.size()-1; i>=0; i--) {
//            System.out.println("Arrays.toString(colList.get(i)) = " + Arrays.toString(colList.get(i)));
//        }
        // 2. 찾을 수가 몇 열인지 찾기
        int col = getCol(num, w);
        // 3. 해당 열에서 순차적으로 row 수를 찾아가며 카운트 후, 카운트수 반환
        return find(colList, num, col);
    }

    private int find(List<int[]> colList, int num, int col) {
//        System.out.println("col = " + col);

        int lastIdx = colList.size()-1;
        int[] top = colList.get(lastIdx);

        int count = 0;
        if(top[col] == 0) {
            lastIdx--;
        }
        for(int row=lastIdx; row>=0; row--) {
            count++;
            if(num == colList.get(row)[col]) {
                break;
            }
        }
        return count;
    }
    private int getCol(int num, int w) {
        int val = num / w;
        int row = num % w == 0 ? val - 1 : val;

        // 짝수 행이면 그 나머지 반환
        if(row % 2 == 0) {
            return num % w == 0 ? w : num % w;
        }
        // 홀수 행이면
        else {
            return num % w == 0 ? 1 : w - (num % w) + 1;
        }
    }

    private void putBox(List<int[]> colList, int n, int w) {
        int[] line = new int[w+1];
        int num = 1;
        int row = 0;
        int col = 1;
        while(num <= n) {
            // 상자 삽입
            line[col] = num;
            // 현재 row가 짝수라면 정방향, 홀수라면 역방향으로 col 변경
            if(row % 2 == 0 && num % w != 0) {
                col++;
            }
            else if(row % 2 == 1 && num % w != 0) {
                col--;
            }
            // 현재 수가 w로 나눠지면 row 상승
            if(num % w == 0 || num == n) {
                row++;
                colList.add(line);
                line = new int[w+1];
            }
            num++;
        }
    }
}
