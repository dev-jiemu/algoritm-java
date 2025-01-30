package src.Books.CodingInterview.StackAndQueue.HistogramArea;

import java.util.Stack;

public class StackHistogram {

    // (오른쪽 - 왼쪽) * 현재막대
    public static int maxAreaUsingStack(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int bar = 0; bar <= histogram.length; bar++) {
            int barHeight;

            if (bar == histogram.length) {
                barHeight = 0;
            } else {
                barHeight = histogram[bar];
            }

            while(!stack.empty() && barHeight < histogram[stack.peek()]) {
                int top = stack.pop(); // 스택에 있는 막대보다 작은 막대

                int left = stack.isEmpty() ? -1 : stack.peek();
                int areaRectWidth = bar - left - 1;
                int area = areaRectWidth * histogram[top];

                maxArea = Integer.max(area, maxArea);
            }

            stack.push(bar);
        }

        return maxArea;
    }
}
