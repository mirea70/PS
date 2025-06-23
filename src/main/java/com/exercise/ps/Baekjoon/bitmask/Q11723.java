package com.exercise.ps.Baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());

        BitMask bitMask = new BitMask(new StringBuilder());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(!(command.equals("all") || command.equals("empty"))) {
                int x = Integer.parseInt(st.nextToken());
                bitMask.execute(command, x);
            }
            else {
                bitMask.execute(command, -1);
            }
        }
        System.out.print(bitMask.sb);
    }
}

class BitMask {
    int bitMask = 0;
    StringBuilder sb;

    public BitMask(StringBuilder sb) {
        this.sb = sb;
    }

    public void execute(String command, int x) {
        switch (command) {
            case "add": {
                add(x);
            }
            break;
            case "remove": {
                remove(x);
            }
            break;
            case "check": {
                check(x);
            }
            break;
            case "toggle": {
                toggle(x);
            }
            break;
            case "all": {
                all();
            }
            break;
            case "empty": {
                empty();
            }
            break;
        }
    }

    public void add(int x) {
        bitMask |= (1 << x - 1);
    }

    public void remove(int x) {
        bitMask &= ~(1 << x - 1);
    }

    public void check(int x) {
        int res = 0;
        if((bitMask & (1 << x - 1)) != 0) {
            res = 1;
        }
        sb.append(res).append("\n");
    }

    public void toggle(int x) {
        if((bitMask & (1 << x - 1)) != 0) {
            remove(x);
        }
        else {
            add(x);
        }
    }

    public void all() {
        bitMask = (1 << 20) - 1;
    }

    public void empty() {
        bitMask = 0;
    }
}
