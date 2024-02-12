package src.Books.ProgrammersTest.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/120875
// Ref. https://school.programmers.co.kr/questions/58575
public class Parallel {

    // 모든 점 사이의 기울기를 계산
    public int solution(int[][] dots) {
        Map<Double, Set<Integer>> slopeMap = new HashMap<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                slopeMap.computeIfAbsent(slope, k -> new HashSet<>()).add(i);
                slopeMap.computeIfAbsent(slope, k -> new HashSet<>()).add(j);
            }
        }

        int result = 0;

        for (Set<Integer> indices : slopeMap.values()) {
            if (indices.size() >= 4) {
                result = 1;
                break;
            }
        }

        return result;
    }

    public double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}
