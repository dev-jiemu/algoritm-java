package src.Books.ProgrammersTest.FullSearch;


import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Network {

    private void visitAll(int computer, int[][] computers, boolean[] isVisited) {

        // 연결된 모든 노드를 찾아야 함
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);

        while(!stack.isEmpty()) {
            int c = stack.pop();

            // 중복검사
            if (isVisited[c]) {
                continue;
            }
            isVisited[c] = true;

            // 전이상태
            for (int next = 0; next < computers[c].length; next++) {
                if (computers[c][next] == 0) {
                    continue; // 연결 안되어있으면 pass
                }
                stack.push(next);
            }
        }

    }

    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            visitAll(i, computers, isVisited);
            answer++;
        }

        return answer;
    }
}
