package src.Programmers.Array;

import java.util.Arrays;

public class BiggestNumber {
//    public String solution(int[] numbers) {
//        String[] numStrings = new String[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            numStrings[i] = String.valueOf(numbers[i]);
//        }
//
//        Arrays.sort(numStrings, (s1, s2) -> {
//            if ("0".equals(s1) && "0".equals(s2)) return 0;
//            return (s2 + s1).compareTo(s1 + s2);
//        });
//
//        StringBuilder answerBuilder = new StringBuilder();
//        for (String s : numStrings) {
//            answerBuilder.append(s);
//        }
//
//        return answerBuilder.toString();
//    }

    // 정확성 11번 케이스: 실패가 발생하길래 문의게시판 확인해보니 s1, s2가 [0, 0] 일때를 고려해야 한다고 하심.
    public String solution(int[] numbers) {
        String[] numStrings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numStrings[i] = String.valueOf(numbers[i]);
        }

        // 모든 배열의 요소가 0으로 이루어져 있으면 정렬계산 안하고 종료함
        boolean allZeros = true;
        for (String s : numStrings) {
            if (!s.equals("0")) {
                allZeros = false;
                break;
            }
        }

        if (allZeros) {
            return "0";
        }

        Arrays.sort(numStrings, (s1, s2) -> {
            if ("0".equals(s1) && "0".equals(s2)) return 0;
            return (s2 + s1).compareTo(s1 + s2);
        });

        StringBuilder answerBuilder = new StringBuilder();
        for (String s : numStrings) {
            answerBuilder.append(s);
        }

        return answerBuilder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        BiggestNumber biggestNumber = new BiggestNumber();

        String result = biggestNumber.solution(numbers);
        System.out.println("result : " + result);
    }
}
