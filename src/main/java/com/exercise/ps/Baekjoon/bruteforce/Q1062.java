package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1062 {
    private static String[] words;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('n');
        set.add('t');
        set.add('i');
        set.add('c');

        char[] alphabets = "bdefghjklmopqrsuvwxyz".toCharArray();
        // k < 5이면 답은 0
        if(K >= 5) {
            combination(alphabets, set, new boolean[21], 0, K);
        }

//        for(int i=0; i<26; i++) {
//            System.out.println("i = " + (char) ('a' + i));
//        }

        System.out.print(max);
    }

    // 0~25 중 k개의 숫자를 뽑아서 set에 그 소문자를 삽입
    private static void combination(char[] alphabets, Set<Character> set, boolean[] visit, int start, int r) {
        if(set.size() == r) {
            int count = 0;
            // N개의 단어들을 순회하며 set에 포함되는 글자로만 이루어져 있다면 카운트
            outer: for(String word : words) {
                for(int i= 4; i<word.length()-4; i++) {
                    if(!set.contains(word.charAt(i))) continue outer;
                }
                count++;
            }
            // 읽을 수 있는 단어 개수의 최대값 갱신
            max = Math.max(max, count);
            return;
        }

        for(int i=start; i<21; i++) {
            if(!visit[i]) {
                visit[i] = true;
                set.add(alphabets[i]);
                combination(alphabets, set, visit, i+1, r);
                visit[i] = false;
                set.remove(alphabets[i]);
            }
        }
    }
}
