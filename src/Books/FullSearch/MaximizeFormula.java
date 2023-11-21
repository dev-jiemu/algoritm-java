package src.Books.FullSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximizeFormula {

    // 연산자 우선순위 새로 지정할때 같은 순위는 없어야 함
    // 음수일 경우 절대값으로 계산
    public long solution(String expression) {
        long answer = 0;

        // split
        // 수식, 문자열 등 다 뽀갬
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if (value > answer) {
                answer = value;
            }
        }

        return answer;
    }

    // 6개뿐이라 굳이 재귀는 안써도 될듯
    private static final String[][] precedences = {
            "+-*".split(""), "+*-".split(""), "-+*".split(""),
            "-*+".split(""), "*+-".split(""), "*-+".split(""),
    };

    private long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }

            }

            
        }

        return Long.parseLong(tokens.get(0)); // 모든 계산이 끝났기 때문에 0번째 인덱스
    }
    
    // 연산결과를 계산하는 메서드
    // 스택으로 구현해도 됨 ㅇㅇ
    private long calculate(long lhs, long rhs, String op) {
        long result = 0;

        if ("+".equals(op)) {
            result = lhs + rhs;
        } else if ("-".equals(op)) {
            result = lhs - rhs;
        } else if ("*".equals(op)) {
            result = lhs * rhs;
        }

        return result;
    }

}
