package main.java.com.exercise.ps.Baekjoon.implementation;

import java.util.Scanner;

public class q1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        // 속해있는 그룹 찾기
        int[] arr = getGroupNCnt(X);
        // 그룹에서 값 찾기
        int[] result = getFraction(arr[0], X, arr[1]);
        assert result != null;
        System.out.println(result[0] + "/" + result[1]);
    }

    private static int[] getGroupNCnt(int X) {
        // 첫 그룹부터 시작해 총 개수를 그룹마다 누적한다.
        // 누적한 총 개수 >= X 이면 반복을 종료 -> 그 그룹에 속해있음
        int group = 0;
        int cnt = 0;
        while(cnt < X) {
            group++;
            cnt = group * (group + 1) / 2;
        }
        return new int[]{group, cnt};
    }


    private static int[] getFraction(int group, int X, int cnt) {
        // cnt에서 1씩 빼가며 X를 찾는다.
        // (순서를 반대로하기때문에 원래 규칙의 반대로 구해야함)

        // 홀수 대각선 열은 분모 down, 분자 up
        if(group % 2 != 0) {
            // 시작 = 분모 : group, 분자 : 1
            int parent = group;
            int child = 1;
            // 반복문 시작
            for(int i=0; i<group; i++) {
                // 찾았으면 분자 분모 리턴
                if(cnt == X) {
                    return new int[]{child, parent};
                }
                cnt--;
                parent--;
                child++;
            }
        }
        // 짝수 대각선 열은 분모 up, 분자 down
        else {
            // 시작 = 분자 : group, 분모 : 1
            int parent = 1;
            int child = group;
            // 반복문 시작
            for(int i=0; i<group; i++) {
                // 찾았으면 분자 분모 리턴
                if(cnt == X) {
                    return new int[]{child, parent};
                }
                cnt--;
                parent++;
                child--;
            }
        }
        return null;
    }
}
