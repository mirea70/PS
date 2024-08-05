package main.java.com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class Transmission {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String ans = "";
        for(int i=1; i<=8; i++) {
            if(i==1) {
                if(arr[i-1] != 1 && arr[i-1] != 8) {
                    ans = "mixed";
                    break;
                }
            }
            else {
                if(arr[0] == 1) {
                    if(arr[i-1] != i) {
                        ans = "mixed";
                        break;
                    }
                }
                else if(arr[0] == 8) {
                    if(arr[i-1] != 8-i+1) {
                        ans = "mixed";
                        break;
                    }
                }
            }
        }
        if(ans.equals("")) {
            if(arr[0] == 1) ans = "ascending";
            if(arr[0] == 8) ans = "descending";
        }

        System.out.print(ans);
    }
}
