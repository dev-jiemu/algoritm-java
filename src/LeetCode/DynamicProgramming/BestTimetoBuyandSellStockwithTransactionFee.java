package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        // hold : 주식을 보유할때 최대 이익
        // sold : 주식을 보유하지 않았을때 최대 이익

        int hold = -prices[0]; // 첫날 샀음
        int sold = 0; // 첫날 안 샀음

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, sold - prices[i]);
            sold = Math.max(sold, hold + prices[i] - fee);
        }

        return sold;
    }
}
