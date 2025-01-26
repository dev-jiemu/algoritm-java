package src.Books.CodingInterview.StackAndQueue.MinStackConstantTime;


import java.util.Stack;

//public class MinStack extends Stack<Integer> {
public class MinStack {
    private int min;
    private final Stack<Integer> stackOfMin;

    public MinStack() {
        stackOfMin = new Stack<>();
    }

//    public Integer push(int value) {
//        if (value <= min()) {
//            stackOfMin.push(value);
//        }
//
//        return super.push(value);
//    }

    public void push(int value) {
        // int / 2 범위를 초과하면 허용 ㄴㄴ
        int r = Math.addExact(value, value);

        if (stackOfMin.empty()) {
            stackOfMin.push(value);
            min = value;
        } else if (value > min) {
            stackOfMin.push(value);
        } else {
            stackOfMin.push(r - min);
            min = value;
        }
    }

//    @Override
//    public Integer pop() {
//        int value = super.pop();
//        if (value == min()) {
//            stackOfMin.pop();
//        }
//
//        return value;
//    }

    public void pop() {
        int top = stackOfMin.peek();

        if (top < min) {
            min = 2 * min - top;
        }

        stackOfMin.pop();
    }

//    public int min() {
//        if (stackOfMin.isEmpty()) {
//            return Integer.MIN_VALUE;
//        } else {
//            return stackOfMin.peek();
//        }
//    }

    public int min() {
        return min;
    }
}
