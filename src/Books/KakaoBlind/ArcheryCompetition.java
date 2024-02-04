package src.Books.KakaoBlind;


import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/92342
// * 완전탐색(재귀)
public class ArcheryCompetition {
    public int[] solution(int n, int[] info) {
        int[] ryan = ryan(0, new int[11], n, info);
        if (ryan == null) {
            return new int[] { -1 };
        }

        return ryan;
    }

    // 완전탐색
    private int scoreDiff(int[] apeach, int[] ryan) {
        int diff = 0;

        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) { // 어피치와 라이언 둘다 못맞추면 체크안함
                continue;
            }

            if (apeach[i] >= ryan[i]) { // 어피치가 라이언보다 많이 맞추거나 같게 맞추었다면 라이언에게 불리하게 적용
                diff -= 10 - i;
            } else {
                diff += 10 - i;
            }
        }

        return diff;
    }

    // 더 낮은 점수를 더 많이 맞춘 경우
    private boolean isPrior(int[] base, int[] comp) {
        for (int i = 10; i >= 0; i--) {
            if (comp[i] == base[i]) {
                continue;
            }
            return comp[i] > base[i];
        }

        return false;
    }

    // (index, hits, n)
    // 종료조건 : hits.length, hits, 0 = null(라이언이 지거나 비기면) or hits(라이언이 이기면)
    // 점화식 : (index, hits, n) = max(hits[index] = hits;(index+2, hits, n - hit))
    private int[] ryan(int index, int[] hits, int n, int[] apeach) {
        if (index == hits.length) {
            if(n > 0) return null;
            if (scoreDiff(apeach, hits) <= 0) return null;
            return Arrays.copyOf(hits, hits.length);
        }

        int maxDiff = 0;
        int[] result = null;
        for (int hit = 0; hit <= n; hit++) {
            hits[index] = hit;
            int[] ryan = ryan(index + 1, hits, n - hit, apeach); // 재귀

            if (ryan != null) {
                int diff = scoreDiff(apeach, ryan);
                // 가장 점수차가 큰 경우 가장 높은 우선순위를 가짐
                // 점수차가 같다면 더 낮은 점수를 많이 맞추는 경우가 높은 우선순위를 가짐
                if (diff > maxDiff || (diff == maxDiff) && isPrior(result, ryan)) {
                    maxDiff = diff;
                    result = ryan;
                }
            }
        }

        return result;
    }
}
