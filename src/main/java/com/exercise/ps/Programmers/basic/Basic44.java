package com.exercise.ps.Programmers.basic;

public class Basic44 {
    public int solution(int n, String control) {

        for(char command : control.toCharArray()) {
             n = command(n, command);
        }

        return n;
    }

    private int command(int n, char command) {
        switch (command) {
            case 'w': {
                n++;
            }
            break;
            case 's': {
                n--;
            }
            break;
            case 'd': {
                n += 10;
            }
            break;
            case 'a': {
                n -= 10;
            }
            break;
        }

        return n;
    }
}
