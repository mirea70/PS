package com.exercise.ps.Baekjoon.dp;

import java.math.BigInteger;
import java.util.*;

public class Q1914 {

    static int N;
    static BigInteger cnt = new BigInteger("0");
    static List<int[]> list = new ArrayList<>();
    static Map<Integer, List<int[]>> dp = new HashMap<>();
    static int[][][] lowDp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lowDp = new int[N+1][4][4];
        if(N <= 20) {
            h(N, 1, 3);
            System.out.println(cnt);
            Iterator<int[]> it = list.iterator();
            while(it.hasNext()) {
                int[] arr = it.next();
                System.out.println(arr[0] + " " + arr[1]);
            }
        }
        else {
            h(N, 1, 3);
            System.out.println(cnt);
        }

    }

    private static int h(int n, int start, int end) {
        Integer key = Arrays.deepHashCode(new int[n][start][end]);
        int other = 6 - (start + end);
        if(N<=20) {
            if(dp.containsKey(key)) {

                List<int[]> value = dp.get(key);
                list.addAll(value);
                int size = value.size();
                cnt = cnt.add(new BigInteger(String.valueOf(size)));
                return size;
            }
            if(n == 1) {
                cnt = cnt.add(new BigInteger("1"));
                list.add(new int[]{start, end});
                dp.put(key, new ArrayList<>(list));
                return 1;
            }

            h(n-1, start, other);
            pm(start, end);
            h(n-1, other, end);
            dp.put(key, new ArrayList<>(list));

            return list.size();
        }
        else {
            if(lowDp[n][start][end] != 0) {
                cnt = cnt.add(new BigInteger(String.valueOf(lowDp[n][start][end])));
                return lowDp[n][start][end];
            }
            if( n == 1) {
                cnt = cnt.add(new BigInteger("1"));
                return lowDp[n][start][end] = 1;
            }

            return lowDp[n][start][end] = h(n-1, start, other) + pm(start, end) + h(n-1, other, end);
        }
    }

    private static int pm(int start, int end) {
        cnt = cnt.add(new BigInteger("1"));
        if(N<=20)
            list.add(new int[]{start, end});
        return 1;
    }
}
