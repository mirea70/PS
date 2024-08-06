package main.java.com.exercise.ps.leetcode.array;

public class BestTimeStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int totalProfit = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }
}
