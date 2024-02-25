package src.Books.ProgrammersTest.PCCP;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121685
public class LawsOfInheritance {
    public String[] solution(int[][] queries) {
        // 첫번째, 마지막 그룹은 항상 RR과 rr임
        // 2, 3번째 그룹은 모양이 같아서 재귀로 풀면 될듯

        return Arrays.stream(queries).map(query -> find(query[0], query[1] - 1)).toArray(String[]::new);
    }

    private String find(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        int slice = (int) Math.pow(4, n-2);
        int group = p / slice;

        if (group == 0) {
            return "RR";
        }
        if(group == 3) {
            return "rr";
        }

        return find(n - 1, p % slice);
    }
}
