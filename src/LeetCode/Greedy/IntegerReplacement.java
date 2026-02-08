package src.LeetCode.Greedy;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        int result = 0;
        long num = n; // overflow 방지용

        // n에 대한 판단 : 홀수일때
//        if (n % 2 != 0) {
//            if ((n + 1) % 5 == 0) {
//                n = n + 1;
//            } else {
//                n = n - 1;
//            }
//        }
        while(num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                if ((num == 3) || (num + 1) % 4 != 0) {
                    num--;
                } else {
                    num++;
                }
            }
            result++;
        }

        return result;
    }
}
