package src.Books.CodingInterview.StackAndQueue.StockSpan;

import java.util.Stack;

public class StockSpan {
    // 브루트 포스로 풀면 O(n2)
    public static int[] stockSpan(int[] stockPrices) {
        Stack<Integer> dayStack = new Stack<>();
        int[] spanResult = new int[stockPrices.length];

        spanResult[0] = 1;
        dayStack.push(0);

        for (int i = 1; i < stockPrices.length; i++) {
            while(!dayStack.empty() && stockPrices[i] > stockPrices[dayStack.peek()]) {
                dayStack.pop();
            }

            if (dayStack.empty()) { // 현재 날짜 가격보다 큰가격이 없으면 주가스팬 = 날짜의 수
                spanResult[i] = i + 1;
            } else {
                spanResult[i] = i - dayStack.peek();
            }

            dayStack.push(i);
        }

        return spanResult;
    }
}
