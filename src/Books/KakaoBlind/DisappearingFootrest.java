package src.Books.KakaoBlind;

// https://school.programmers.co.kr/learn/courses/30/lessons/92345
public class DisappearingFootrest {

    // 내 위치와 상대 위치를 같이 가지고 있을 필요가 있음
    private static class Coord {
        public final int x;
        public final int y;

        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 이동회수, 승리여부 반환
    private static class Result {
        public final boolean win;
        public final int turns;

        private Result(boolean win, int turns) {
            this.win = win;
            this.turns = turns;
        }
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    // 재귀
    private Result game(Coord player, Coord opponent, int[][] board) {
        if (board[player.y][player.x] == 0) {
            return new Result(false, 0);
        }

        boolean win = false;
        int winTurns = Integer.MAX_VALUE; // 승리하는 경우일때 가장 적은 이동횟수
        int loseTurns = Integer.MIN_VALUE; // 승리하는 경우가 없을때 가장 큰 이동횟수

        board[player.y][player.x] = 0;

        for(int d = 0; d < 4; d++) {  // 재귀
            int nx = player.x + dx[d];
            int ny = player.y + dy[d];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[ny].length) {
                continue;
            }
            if (board[ny][nx] == 0) {
                continue;
            }

            Result result = game(opponent, new Coord(nx, ny), board);
            if (!result.win) { // 상대 플레이어의 결과를 리턴함
                win = true;
                winTurns = Math.min(winTurns, result.turns);
            } else if (!win) {
                loseTurns = Math.max(loseTurns, result.turns);
            }
        }

        board[player.y][player.x] = 1;


        if (win) {
            return new Result(true, winTurns + 1); // 다음턴으로 넘기는 이동횟수 1 추가
        }

        if (loseTurns == Integer.MIN_VALUE) {
            return new Result(false, 0);
        }

        return new Result(false, loseTurns + 1);
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return game(new Coord(aloc[1], aloc[0]), new Coord(bloc[1], bloc[0]), board).turns;
    }
}
