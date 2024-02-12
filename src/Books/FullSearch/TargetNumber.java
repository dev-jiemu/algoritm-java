package src.Books.FullSearch;


import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class TargetNumber {
    private static class State {
        public final int index;
        public final int acc;

        State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }

    public int solution(int[] numbers, int target) {

        // 초기상태
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));

        int count = 0;

        // 탐색
        while (!s.isEmpty()) {
            State state = s.pop();

            // 현재 상태 처리
            if (state.index == numbers.length) {
                if (state.acc == target) {
                    count++;
                }
                continue;
            }

            // 상태 전이
           s.push(new State(state.index + 1, state.acc - numbers[state.index])); // + 를 선택한 경우
           s.push(new State(state.index + 1, state.acc + numbers[state.index])); // - 를 선택한 경우
        }

        return count;
    }
}
