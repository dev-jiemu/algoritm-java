package src.Books.ProgrammersTest.PCCP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121684
public class AthleticCompetition {

    private final Map<String, Integer> mem = new HashMap<>();

    public int solution(int[][] ability) {
        return max(0, new boolean[ability.length], ability);
    }

    private int max(int student, boolean[] isChosen, int[][] ability) {
        if (student == ability.length) {
            return 0;
        }

        String memKey = toString(student, isChosen); // 메모이제이션
        if (mem.containsKey(memKey)) {
            return mem.get(memKey);
        }

        int max = max(student + 1, isChosen, ability);

        for(int i = 0; i < ability[student].length; i++) {
            if (isChosen[i]) {
                continue;
            }

            isChosen[i] = true;
            int score = max(student + 1, isChosen, ability) + ability[student][i];
            if (score > max) {
                max = score;
            }
            isChosen[i] = false;
        }

        mem.put(memKey, max);
        return max;
    }

    private String toString(int student, boolean[] isChosen) {
        return student + Arrays.toString(isChosen);
    }
}
