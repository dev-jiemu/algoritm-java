package src.Programmers.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 선인장 숨기기
// https://school.programmers.co.kr/learn/courses/30/lessons/468379
// TODO : 2D 슬라이딩 복습 필요함
public class HideTheCactus {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = {0, 0};

        int[][] time = new int[m][n];
        for (int[] row : time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 빗방울 떨어진 순서
        for (int i = 0; i < drops.length; i++) {
            time[drops[i][0]][drops[i][1]] = i + 1;
        }

        // weight, height
        int[][] rowMin = new int[m][n - w + 1];
        int[][] colMin = new int[m - h + 1][n - w + 1];

        // 슬라이딩 윈도우
        for (int r = 0; r < m; r++) {
            // 최소값 꺼내기
            Deque<Integer> deque = new ArrayDeque<>();
            for (int c = 0; c < n; c++) {
                while(!deque.isEmpty() && time[r][deque.peekLast()] >= time[r][c]) {
                    deque.pollLast();
                }
                deque.addLast(c);

                // 덱 앞쪽이 윈도우 시작보다 작으면 범위 밖이므로 제거
                if (deque.peekFirst() < c - w + 1) {
                    deque.pollFirst();
                }

                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = time[r][deque.peekFirst()];
                }
            }

        }

        for (int c = 0; c < n - w + 1; c++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                while (!deque.isEmpty() && rowMin[deque.peekLast()][c] >= rowMin[r][c]) {
                    deque.pollLast();
                }
                deque.addLast(r);

                if (deque.peekFirst() < r - h + 1) {
                    deque.pollFirst();
                }

                if (r >= h - 1) {
                    colMin[r - h + 1][c] = rowMin[deque.peekFirst()][c];
                }
            }
        }

        int maxVal = -1;

        for (int r = 0; r < m - h + 1; r++) {
            for (int c = 0; c < n - w + 1; c++) {
                if (colMin[r][c] > maxVal) {
                    maxVal = colMin[r][c];
                    answer = new int[]{r, c};
                }
            }
        }

        return answer;
    }
}
