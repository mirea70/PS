package com.exercise.ps.softeer;

import java.io.*;

public class Pans {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            // 0~9까지 켜져있어야할 전광판 정의하기
            String[] input = br.readLine().split(" ");
            String A = input[0];
            String B = input[1];
            // A -> 현재 전광판 그리기
            Pan[] Apans = new Pan[5];
            int lastIdx = A.length()-1;
            for(int i=0; i<5; i++) {
                if(i<4-lastIdx) Apans[i] = new Pan('-');
                else Apans[i] = new Pan(A.charAt(i-(4-lastIdx)));
            }
            // B -> 현재 전광판에서 바뀌어야할 전광판으로 바꾸기 -> 스위치 누를때마다 CNT
            Pan[] Bpans = new Pan[5];
            int lastIdx2 = B.length()-1;
            for(int i=0; i<5; i++) {
                if(i<4-lastIdx2) Bpans[i] = new Pan('-');
                else Bpans[i] = new Pan(B.charAt(i-(4-lastIdx2)));
            }
            int cnt = 0;



            for(int i=0; i<5; i++) {
                // A와 B를 비교
                for(int j=0; j<7; j++) {
                    if(Apans[i].status[j] != Bpans[i].status[j]) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }


}

class Pan {
    boolean[] status = new boolean[7];

    public Pan(char c) {
        switch(c) {
            case '0': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[3] = true;
                this.status[4] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            case '1': {
                this.status[3] = true;
                this.status[6] = true;
            }
            break;
            case '2': {
                this.status[0] = true;
                this.status[2] = true;
                this.status[3] = true;
                this.status[4] = true;
                this.status[5] = true;
            }
            break;
            case '3': {
                this.status[0] = true;
                this.status[2] = true;
                this.status[3] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            case '4': {
                this.status[1] = true;
                this.status[2] = true;
                this.status[3] = true;
                this.status[6] = true;
            }
            break;
            case '5': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[2] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            case '6': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[2] = true;
                this.status[4] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            case '7': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[3] = true;
                this.status[6] = true;
            }
            break;
            case '8': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[2] = true;
                this.status[3] = true;
                this.status[4] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            case '9': {
                this.status[0] = true;
                this.status[1] = true;
                this.status[2] = true;
                this.status[3] = true;
                this.status[5] = true;
                this.status[6] = true;
            }
            break;
            default : {
                this.status[0] = false;
                this.status[1] = false;
                this.status[2] = false;
                this.status[3] = false;
                this.status[4] = false;
                this.status[5] = false;
                this.status[6] = false;
            }
            break;
        }
    }
}
