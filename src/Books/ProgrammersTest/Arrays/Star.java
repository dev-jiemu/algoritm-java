package src.Books.ProgrammersTest.Arrays;

import java.util.*;

public class Star {
//    1. 모든 직선 쌍에 대한 반복
//    2. 저장된 정수들에 대해 x, y 좌표값의 최대/최소 구하기
//    3. 2차원 배열 크기 정함
//    4. 별 표시
    public String[] solution(int[][] line) {

        // 정수 좌표만 저장
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 최소, 최대값  기준으로 배열 크기 설정
        Point max = getMaximumPoint(points);
        Point min = getMinimumPoint(points);

        // 크기를 구하는거니까 +1
        int width = (int)(max.x - min.x + 1);
        int height = (int)(max.y - min.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 별찍기
        for (Point p : points) {
            int x = (int)(p.x - min.x);
            int y = (int)(max.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    // 최대, 최소값 구하기
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

}

class Point {
    final long x, y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
