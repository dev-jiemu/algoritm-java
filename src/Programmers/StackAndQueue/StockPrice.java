package src.Programmers.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> priceQueue = new LinkedList<>();
        for (int price : prices) {
            priceQueue.add(price);
        }

        int index = 0;
        while(!priceQueue.isEmpty()) {
            int current = priceQueue.poll();
            int count = 0;

            for (int item : priceQueue) {
                if (current > item) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }

            answer[index] = count;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};

        StockPrice stockPrice = new StockPrice();
        int[] result = stockPrice.solution(prices);

        for (int item : result) {
            System.out.println(item);
        }
    }
}
