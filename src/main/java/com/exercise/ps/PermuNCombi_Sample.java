package com.exercise.ps;

import java.util.Arrays;

class PermuNCombi_Sample {
    public static void main(String[] args) {
        int[] elements = new int[]{7,9,1};
        duPermutation(elements, new int[2], 0, 2);
    }

    private static void permutation(int[] arr, int[] current, boolean[] visited, int depth, int r) {

        if(depth == r) {
            System.out.println(Arrays.toString(current));
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = arr[i];
                permutation(arr, current, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    private static void duPermutation(int[] arr, int[] current, int depth, int r) {

        if(depth == r) {
            System.out.println(Arrays.toString(current));
            return;
        }

        for(int i=0; i<arr.length; i++) {
            current[depth] = arr[i];
            duPermutation(arr, current, depth+1, r);
        }
    }

    private static void combination(int[] arr, int[] current, boolean[] visited, int depth, int start, int r) {
        if(depth == r) {
            System.out.println(Arrays.toString(current));
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = arr[i];
                combination(arr, current, visited, depth+1, i+1, r);
                visited[i] = false;
            }
        }
    }

    private static void duCombination(int[] arr, int[] current, int depth, int start, int r) {
        if(depth == r) {
            System.out.println(Arrays.toString(current));
            return;
        }

        for(int i=start; i<arr.length; i++) {
            current[depth] = arr[i];
            duCombination(arr,current,depth+1,i,r);
        }
    }
}
