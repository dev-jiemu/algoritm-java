package src.Books.DataStructsAndAlgoritm.Optimization;

public class InsertSort {
    public static void insert_sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i]; // 옮길 대상
            int position = i - 1; // 옮길 대상의 직전 인덱스에서 시작시킴

            while (position >= 0) {
                if (array[position] > temp) { // temp 보다 크면 교체
                    array[position + 1] = array[position];
                    position--;
                } else {
                    break;
                }
            }

            array[position + 1] = temp; // 오른쪽으로 시프트 하고나서 남은자리에 넣음
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 3, 4, 2};
        InsertSort.insert_sort(array);

        for(int item : array) {
            System.out.println(item);
        }
    }
}
