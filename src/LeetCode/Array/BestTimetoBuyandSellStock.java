package src.LeetCode.Array;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;

            // 최대 이익
            maxProfit = Math.max(maxProfit, currentProfit);

            // 최저가
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
