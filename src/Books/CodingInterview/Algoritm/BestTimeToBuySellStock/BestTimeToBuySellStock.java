package src.Books.CodingInterview.Algoritm.BestTimeToBuySellStock;

public class BestTimeToBuySellStock {
    // 1번씩민 매도 매수 가능하다고 했을때
    public static int maxProfitOneTransaction(int[] prices) {
        int result = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

    // 두번씩 사고 팔고 가능할때
    // 동적 프로그래밍
    public static int maxProfitTwoTransaction(int[] prices) {
        int result = 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, left[i] + right[i]);
        }

        return result;
    }

    // 회수 무제한일때
    public static int maxProfitUnlimitedTransaction(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                result += diff;
            }
        }

        return result;
    }

    // 거래횟수가 k 번일때
    public static int maxProfitKTransaction(int[] prices, int k) {
        int[] temp = new int[k + 1];
        int[] result = new int[k + 1];

        for (int i = 0; i < prices.length; i++) { // i번째 날에 마지막 거래를 했을때 최대 수익
            int diff = prices[i + 1] - prices[i];
            for(int j = k; j >= 1; j--) { // i번째 날까지의 j번 거래의 최대 수익
                temp[j] = Math.max(result[j - 1] + Math.max(diff, 0), temp[j] + diff);
                result[j] = Math.max(temp[j], result[j]);
            }
        }

        return result[k];
    }
}
