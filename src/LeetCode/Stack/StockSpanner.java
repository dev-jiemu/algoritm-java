package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
class StockSpanner {
    class Spanner {
        int price;
        int span;

        public Spanner(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Spanner> stack = new Stack<>();

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Spanner(price, span));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */