package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Character>> col = new ArrayList<>();
        List<Character> row = new ArrayList<>();
        for(int i=0; i<5; i++) {
            row = new ArrayList<>();
            String s = br.readLine();
            for(char c : s.toCharArray()) {
                row.add(c);
            }
            col.add(row);
        }

        StringBuilder sb = new StringBuilder();
        int rowIdx = 0;
        while(rowIdx <= 15) {
            for(int i=0; i<col.size(); i++) {
                if(rowIdx > col.get(i).size()-1) continue;
                char c = col.get(i).get(rowIdx);
                if(c != ' ') sb.append(c);
            }
            rowIdx++;
        }
        System.out.print(sb.toString());
    }
}
