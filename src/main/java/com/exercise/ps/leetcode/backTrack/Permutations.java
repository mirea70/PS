package main.java.com.exercise.ps.leetcode.backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        recul(nums, new ArrayList<Integer>(), new HashSet<Integer>(), 0, len);
        return list;
    }

    private void recul(int[] nums, List<Integer> current, Set<Integer> checkSet, int depth, int k) {
        if(depth == k) {
            list.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(checkSet.contains(nums[i])) continue;
            checkSet.add(nums[i]);
            current.add(nums[i]);
            recul(nums, current, checkSet, depth+1, k);
            checkSet.remove(current.get(current.size()-1));
            current.remove(current.size()-1);
        }
    }
}
