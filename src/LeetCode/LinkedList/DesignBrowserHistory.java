package src.LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-browser-history/
public class DesignBrowserHistory {

    // forward 때문에 stack 은 안되는걸로 ㅇㅂㅇ... -> pop 하면 안되고 stack 으로 하더라도 너무 비효율적임
    private List<String> history;
    private int current;

    public DesignBrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.current = 0;
    }

    public void visit(String url) {
        // 현재위치 이후의 forward는 제거함
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}
