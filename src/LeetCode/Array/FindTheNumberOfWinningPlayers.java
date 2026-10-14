package src.LeetCode.Array;

// 3238. Find the Number of Winning Players
// https://leetcode.com/problems/find-the-number-of-winning-players/description/
public class FindTheNumberOfWinningPlayers {
    /*
    Input: n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]
    Output: 2
    Explanation:
    Player 0 and player 1 win the game, while players 2 and 3 do not win.
     */
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] count = new int[n][11];
        int answer = 0;

        for(int i = 0; i < pick.length; i++) {
            count[pick[i][0]][pick[i][1]]++;
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < 11; j++) {
                if (count[i][j] >= i + 1) {
                    answer++;
                    break; // 중복체크 방지를 위해 넘어감
                }
            }
        }

        return answer;
    }
}
