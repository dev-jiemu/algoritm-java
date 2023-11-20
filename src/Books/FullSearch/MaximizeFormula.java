package src.Books.FullSearch;

public class MaximizeFormula {

    // 연산자 우선순위 새로 지정할때 같은 순위는 없어야 함
    // 음수일 경우 절대값으로 계산
    // expression이 중위표기법을 위반하는지도 체크해야할듯?
    public long solution(String expression) {
        long answer = 0;


        return answer;
    }

    // 6개뿐이라 굳이 재귀는 안써도 될듯
    private static final String[][] precedences = {
            "+-*".split(""), "+*-".split(""), "-+*".split(""),
            "-*+".split(""), "*+-".split(""), "*-+".split(""),
    };
    
    // 연산결과를 계산하는 메서드
    // 스택으로 구현해도 됨 ㅇㅇ
    private long calculate(long lhs, long rhs, String op) {
        long result = 0;

        switch (op) {
            case "+":
                result = lhs + rhs;
            case "-":
                result = lhs - rhs;
            case "*":
                result = lhs * rhs;
            default:
                result = 0;
        }

        return result;
    }

}
