package src.Books.DataStructsAndAlgoritm.Binary;

// 이진탐색 : **정렬된 데이터를 기준** 으로 반으로 나눠서 찾음
public class BinarySearch {
    public static int BinarySearch(int[] arrays, int value) {
        int lower_bound = 0;
        int upper_bound = arrays.length - 1;

        while (lower_bound <= upper_bound) {
            int mid_point = (upper_bound + lower_bound) / 2;

            int mid_value = arrays[mid_point];

            if (value == mid_value) { // 찾았으면 리턴
                return mid_value;
            } else if (value < mid_value) {
                upper_bound = mid_point - 1;
            } else {
                lower_bound = mid_point + 1;
            }
        }

        return 0; // 못찾음
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5};

        // 못 찾으면 0 떨어짐
        System.out.println("result : " + BinarySearch(arrays, 7));
    }
}