package main.java.com.exercise.ps.leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if(nums.length == 0) return list;
        if(nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int a = nums[0];
        int b = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                b = nums[i];
                if(i == nums.length-1) {
                    if(a == b) {
                        list.add(String.valueOf(a));
                    }
                    else {
                        list.add(a + "->" + b);
                    }
                }
            }
            else {
                if(a == b) {
                    list.add(String.valueOf(a));
                }
                else {
                    list.add(a + "->" + b);
                }
                a = nums[i];
                b = nums[i];
                if(i == nums.length-1) {
                    list.add(String.valueOf(a));
                }
            }
        }
        return list;
    }
}
