package src.Books.ProgrammersTest.PCCP;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121689
public class CafeExpansion {
    private static class Order {
        public final int time;
        public final int duration;

        public Order(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }

    public int solution(int[] menu, int[] order, int k) {
        Order[] orders = new Order[order.length];

        for(int i = 0; i < order.length; i++) {
            orders[i] = new Order(k * i, menu[order[i]]);
        }

        int max = 0;

        int time = 0;
        int end = 0;
        for (int start = 0; start < orders.length; start++) {
            Order o = orders[start];

            if (time < o.time) { // 주문이 별도로 대기하지 않은 상황임
                time = o.time;
            }

            time += o.duration;

            while(end < orders.length && orders[end].time < time) {
                end++;
            }

            // 손님들이 한 주문 = 대기하는 주문
            // = [start, end]
            int count = end - start;
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}
