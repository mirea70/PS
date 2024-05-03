package com.exercise.ps.leetcode.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> gathers = new ArrayList<>();
        for(int i=0; i<9; i++) {
            Set<Character> gather = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> row = new HashSet<>();
            gathers.add(gather);
            cols.add(col);
            rows.add(row);
        }
        // board을 순회하며, 행 체크, 열체크, 모임 체크를한다.
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                char c = board[i][j];
                if(Character.isDigit(c)){
                    if(cols.get(i).contains(c)) return false;
                    if(rows.get(j).contains(c)) return false;
                    int gathersIdx = getListIdx(i, j);
                    if(gathers.get(gathersIdx).contains(c)) return false;
                    cols.get(i).add(c);
                    rows.get(j).add(c);
                    gathers.get(gathersIdx).add(c);
                }
            }
        }
        return true;
    }
    // 모음 순번 찾기
    private int getListIdx(int y, int x) {
        if(y < 3) {
            if(x < 3) return 0;
            else if(x < 6) return 1;
            else return 2;
        }
        else if(y < 6) {
            if(x < 3) return 3;
            else if(x < 6) return 4;
            else return 5;
        }
        else {
            if(x < 3) return 6;
            else if(x < 6) return 7;
            else return 8;
        }
    }
}
