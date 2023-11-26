package src.Books.Hash;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/120875
// 테스트 케이스 12번부터 미스나는데 수정 필요함
public class Parallel {

    // 모든 점 사이의 기울기를 계산
    public int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();
        for(int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
                // 같은 기울기가 있으면 평행한 선이 존재하는 것임
                if (slopes.contains(slope)) {
                    return 1;
                }
                slopes.add(slope);
            }
        }

        return 0;
    }

    public double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}
