package src.Books.ProgrammersTest.PCCP;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121687
public class RobotForTraining {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[] solution(String command) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (char c : command.toCharArray()) {
            switch (c) {
                case 'R':
                    d = (d + 1) % 4;
                    break;
                case 'L':
                    d = (d + 3) % 4;
                    break;
                case 'G':
                    x += dx[d];
                    y += dy[d];
                    break;
                case 'B':
                    x -= dx[d];
                    y -= dy[d];
                    break;
            }
        }

        return new int[]{x, y};
    }
}
