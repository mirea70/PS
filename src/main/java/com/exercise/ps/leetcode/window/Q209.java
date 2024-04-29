package com.exercise.ps.leetcode.window;

import java.util.*;

class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 포인터를 두개 두고, 그 합이 target보다 커질때까지 새로운 배열을 만든다
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        boolean isExist = false;
        while(end <= nums.length && start <= nums.length) {
            if(sum >= target) {
                isExist = true;
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }
            else {
                if(end + 1 < nums.length) {
                    end++;
                    sum += nums[end];
                }
                else break;
            }
        }

        if(!isExist) min = 0;
        return min;
    }
}
