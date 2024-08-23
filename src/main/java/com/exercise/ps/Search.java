package com.exercise.ps;

public class Search {
    public static void main(String[] args) {
        int[] arr = {7,4,0,5,3};
        int target = 8;
        System.out.println("순차검색 - 정렬X : " + search_nonSorted(arr, target));
        int[] arr2 = {0,3,4,5,7};
        System.out.println("순차검색 - 정렬O : " + search_sorted(arr2, target));
        System.out.println("이진검색 : " + search_sorted(arr2, target));
    }

    // 1. 순차검색 - 정렬 안되어 있는 경우
    private static int search_nonSorted(int[] arr, int target) {
        // 배열을 순회
        for(int i=0; i<arr.length; i++) {
            // 타겟과 일치하면 해당 인덱스 리턴
            if(target == arr[i]) return i;
        }
        // 순회끝
        // 못찾았으니 -1 리턴
        return -1;
    }
    // 2. 순차검색 - 오름차순 정렬되어 있는 경우
    private static int search_sorted(int[] arr, int target) {
        // 배열 순회
        for(int i=0; i<arr.length; i++) {
            // 현재 값 > target이면 그냥 -1 리턴
            if(arr[i] > target) return -1;
            // 같으면 해당 인덱스 리턴
            else if(arr[i] == target) return i;
        }
        // 순회 끝
        // 못 찾았으니 -1 리턴
        return -1;
    }
    // 3. 이진탐색
    private static int search_binary(int[] arr, int target) {
        // 개념
        // 자료의 가운데 값과 비교해 다음 검색 위치를 결정하며 검색을 계속 진행하는 방법
        // 검색 범위를 반으로 줄여가며 보다 빠르게 수행함
        // 시간복잡도 : O(logN)
        // 유의할 점
        // - 정렬이 되어 있어야함

        // 구현
        // 자료의 시작, 끝점 저장
        int left = 0;
        int right = arr.length-1;
        // 시작 <= 끝점 일동안 반복
        while(left <= right) {
            // 중앙 인덱스 구하기
            int mid = (left + right) / 2;
            // 중앙 값이 타겟과 일치하면 중앙 인덱스 리턴
            if(arr[mid] == target) return mid;
            // 중앙 값 > 타겟이면 끝점 = mid - 1
            else if(target < arr[mid]) right = mid-1;
            // 중앙 값 < 타겟이면 시작점 = mid + 1
            else left = mid+1;
        }
        // 반복 끝
        // 못 찾았으므로 -1 리턴
        return -1;
    }
}
