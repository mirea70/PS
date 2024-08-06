package main.java.com.exercise.ps.leetcode.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int rub = 0;
        int notRub = 0;

        for(int i=0; i<nums.length; i++) {
            int curRub = notRub + nums[i];
            notRub = Math.max(notRub, rub);
            rub = curRub;
        }
        return Math.max(rub, notRub);
    }
}
