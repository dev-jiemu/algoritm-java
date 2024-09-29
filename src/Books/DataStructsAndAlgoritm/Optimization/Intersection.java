package src.Books.DataStructsAndAlgoritm.Optimization;

import java.util.ArrayList;

// 두 배열의 교집합을 구해보기
public class Intersection {

    public static int[] intersection(int[] first, int[] second) {
        ArrayList<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    intArray.add(first[i]);
                    break;  // 두 배열에 공통값이 있으면 굳이 더 비교하지 않아도 됨
                }
            }
        }

        int[] result = new int[intArray.size()];
        for (int i = 0; i < intArray.size(); i++) {
            result[i] = intArray.get(i);
        }

        return result;
    }


}
