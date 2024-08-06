package main.java.com.exercise.ps.Baekjoon.union;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1043_2 {

    private static int[] parent;
    private static Set<Integer> factMans = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int factCnt = Integer.parseInt(st2.nextToken());
        if(factCnt == 0) System.out.print(m);
        else {
            for(int i=0; i<factCnt; i++) {
                factMans.add(Integer.parseInt(st2.nextToken()));
            }
            List<Set<Integer>> parties = new ArrayList<>();
            for(int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                Set<Integer> party = new HashSet<>();
                int x = Integer.parseInt(st.nextToken());
                party.add(x);
                for(int j=1; j<k; j++) {
                    int y = Integer.parseInt(st.nextToken());
                    party.add(y);
                    union(x,y);
                }
                parties.add(party);
            }

            int cnt = 0;
            for(Set<Integer> party : parties) {
                boolean canLie = true;
                for(int person : party) {
                    if(factMans.contains(find(parent[person]))) {
                        canLie  = false;
                        break;
                    }
                }
                if(canLie) cnt++;
            }
            System.out.print(cnt);
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(factMans.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        parent[ry] = rx;
    }
}
