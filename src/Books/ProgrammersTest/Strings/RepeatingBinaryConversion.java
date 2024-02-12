package src.Books.ProgrammersTest.Strings;


// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class RepeatingBinaryConversion {
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        // 문자열이 1만 남을때까지 반복
        // 1 남은거로 이진법으로 변환 -> 1만 남을때까지 반복
        while(!s.equals("1")) {
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;

            int ones = s.length() - zeros; // 1의 개수
            s = Integer.toString(ones, 2); // 2진법
        }


        return new int[] {loop, removed};
    }

    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        return zeros;
    }
}
