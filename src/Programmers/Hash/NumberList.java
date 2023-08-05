package src.Programmers.Hash;

import java.util.Arrays;

public class NumberList {

    // 효율성 테스트 개선 버전
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] number = new String[]{"119", "97674223", "1195524421"};
        boolean result = solution(number);

        System.out.println("result : " + result);
    }
}
