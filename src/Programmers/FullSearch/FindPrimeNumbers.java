package src.Programmers.FullSearch;

import java.util.*;

public class FindPrimeNumbers {

    public int solution(String numbers) {
        int answer = 0;

        // 0  ~ 9999999 까지
        int[] ints = new int[10];
        String[] split = numbers.split("");
        for (String s : split) {
            ints[Integer.parseInt(s)]++;
        }

        int maxNum = (int) Math.pow(10, numbers.length()) - 1; // 입력된 numbers로 만들 수 있는 최대 숫자

        for (int i = 2; i <= maxNum; i++) { // <=로 변경하여 최대 숫자까지 확인
            if (isPrime(i) && isContain(ints, i)) {
                answer++;
            }
        }

        return answer;
    }


    // 소수 판별 메서드
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        // 약수체크
        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int)Math.sqrt(number) + 1;
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 배열로 만들수 있는지 확인
    private boolean isContain(int[] ints, int k) {

        int[] temp = ints.clone();

        while (k > 0) {
            if (temp[k % 10] == 0) {
                return false;
            }

            temp[k % 10]--;
            k /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        String numbers = "011";
        FindPrimeNumbers findPrimeNumbers = new FindPrimeNumbers();

        int result = findPrimeNumbers.solution(numbers);
        System.out.println("result : " + result);
    }
}
