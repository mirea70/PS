package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1043 {
    public static void main(String[] args) throws IOException {
        Set<Integer> factMans = new HashSet<>();
        ArrayList<Set<Integer>> parties = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        String[] inputs2 = br.readLine().split(" ");
        if(inputs2.length > 1) {
            for(int i=1; i<inputs2.length; i++) {
                factMans.add(Integer.parseInt(inputs2[i]));
            }
        }
        for(int i=0; i<m; i++) {
            String[] inputs3 = br.readLine().split(" ");
            int k = Integer.parseInt(inputs3[0]);
            Set<Integer> persons = new HashSet<>();
            for(int j=1; j<=k; j++) {
                int val = Integer.parseInt(inputs3[j]);
                persons.add(val);
            }
            parties.add(persons);
        }

        boolean updated;
        do {
            updated = false;
            for(Set<Integer> party : parties) {
                boolean hasFactMan = false;
                for(int person : party) {
                    if(factMans.contains(person)) {
                        hasFactMan = true;
                        break;
                    }
                }
                if(hasFactMan) {
                    for(int person : party) {
                        if(!factMans.contains(person)) {
                            factMans.add(person);
                            updated = true;
                        }
                    }
                }
            }
        } while(updated);

        int cnt = 0;
        for(Set<Integer> party : parties) {
            boolean canLai = true;
            for(int person : party) {
                if (factMans.contains(person)) {
                    canLai = false;
                    break;
                }
            }
            if(canLai) cnt++;
        }
        System.out.print(cnt);
    }
}
