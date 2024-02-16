package src.Books.ProgrammersTest.FullSearch;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class WordConversion {

    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for(int i = 0; i < words.length; i++) {
                String next = words[i];

                if (!isConvertable(state.word, next)) {
                    continue;
                }

                if (isVisited[i]) {
                    continue; // 이미 검사함
                }

                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }

    private boolean isConvertable(String src, String dst) {
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;
        for(int i = 0; i < srcArr.length; i++) {
            if(srcArr[i] != dstArr[i]) {
                diff++;
            }
        }

        return diff == 1; // 1개만 다르면 true
    }


}
