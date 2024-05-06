package src.Books.CodingInterview.Recursion.Subset;

public class Subset {

    // 1. 재귀로 풀기
    // givenSum : 목표로 하는 숫자
    public static void findSumRecursive(int[] arr, int index, int currentSum, int givenSum, int[] subset) {
        if (currentSum == givenSum) {
            for (int i = 0; i < subset.length; i++) {
                System.out.print("\nSubset found: ");
                if (subset[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
        } else if (index != arr.length) {
            subset[index] = 1; // 추가
            currentSum += arr[index];

            findSumRecursive(arr, index + 1, currentSum, givenSum, subset);

            currentSum -= arr[index];
            subset[index] = 0; // 제거

            findSumRecursive(arr, index + 1, currentSum, givenSum, subset);
        }
    }

    // 2. 동적 프로그래밍으로 풀기
    // 복습필요: Ref. https://hongjw1938.tistory.com/47
    public static boolean findSumDP(int[] arr, int givenSum) {
        boolean[][] matrix = new boolean[arr.length + 1][givenSum + 1];

        // 초기화
        for(int i = 1; i <= givenSum; i++) {
            matrix[0][i] = false;
        }

        for (int i = 0; i <= arr.length; i++) {
            matrix[i][0] = true;
        }

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 1; j <= givenSum; j++) {
                matrix[i][j] = matrix[i - 1][j]; // 이전 행 값

                if (!matrix[i][j] && j >= arr[i - 1]) { // false 라면
                    matrix[i][j] = matrix[i][j] || matrix[i - 1][j - arr[i - 1]]; // 현재 행의 T/F 판별
                }
            }
        }

        printSubsetMatrix(arr, givenSum, matrix);
        printOneSubset(matrix, arr, arr.length, givenSum);

        return matrix[arr.length][givenSum];
    }

    private static void printOneSubset(boolean[][] matrix, int[] arr, int row, int col) {
        int i = row;
        int j = col;

        System.out.println("\nSubset: ");
        while (i > 0 && j >= 0) {
            int value = arr[i - 1];
            if (j - value >= 0 && matrix[i - 1][j - value] && !matrix[i - 1][j]) {
                i = i - 1;
                j = j - value;
                System.out.print(value + " ");
            } else {
                i--;
            }
        }
    }

    private static void printSubsetMatrix(int[] arr, int givenSum, boolean matrix[][]) {
        System.out.println("\nSubset matrix for sum " + givenSum + ": ");
        System.out.print("\t");
        for (int j = 0; j <= givenSum; j++) {
            System.out.print(j + "\t");
        }

        System.out.println();

        for (int i = 0; i <= arr.length; i++) {
            System.out.print(i == 0 ? 0 + "\t" : arr[i - 1] + "\t");
            for (int j = 0; j <= givenSum; j++) {
                System.out.print(matrix[i][j] ? "T\t" : "F\t");
            }

            System.out.println();
        }
    }

}
