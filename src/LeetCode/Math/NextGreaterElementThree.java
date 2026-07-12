package src.LeetCode.Math;

// 556. Next Greater Element III
// https://leetcode.com/problems/next-greater-element-iii/description/
public class NextGreaterElementThree {
    // 다음 순열 알고리즘 ㅇㅂㅇ?
    // Ref. https://yoongrammer.tistory.com/109
    // 1. 뒤에서부터 왼쪽으로 가면서 오름차순이 깨지는 시점 찾음
    // 2. i보다 오른쪽에서 digits[i] 보다 크면서 가장 작은 값을 찾아서 바꿈
    // 3. 교환 지점 오른쪽 부분을 다시 뒤집음
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        // 1.
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // 없으면 종료
        if (i < 0) {
            return -1;
        }


        // 2. 큰 중에 가장 작은 수 찾기
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);

        // 3. 뒤집기
        reverse(digits, i + 1, digits.length - 1);

        // 32비트 정수 범위 찾으라고 했음..
        try {
            long result = Long.parseLong(new String(digits));
            if (result > Integer.MAX_VALUE) {
                return -1;
            }
            return (int) result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
