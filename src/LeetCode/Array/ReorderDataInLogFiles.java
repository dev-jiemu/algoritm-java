package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.Collections;


public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letter = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();

        for(int i = 0; i < logs.length; i++) {
            String[] parts = logs[i].split(" ", 2);
            char first = parts[1].charAt(0);

            if (Character.isLetter(first)) {
                letter.add(logs[i]);
            } else {
                number.add(logs[i]);
            }
        }

        // 문자 정렬
        Collections.sort(letter, (a, b) -> {
            String[] partsA = a.split(" ", 2);
            String[] partsB = b.split(" ", 2);

            /*
            더 줄이려면 이렇게 쓸수 있는데 이게 더 직관적이라서

            int cmp = partsA[1].compareTo(partsB[1]);
            if (cmp != 0) return cmp;
            return partsA[0].compareTo(partsB[0]);
             */

            if (partsA[1].equals(partsB[1])) {
                return partsA[0].compareTo(partsB[0]);
            } else {
                return partsA[1].compareTo(partsB[1]);
            }
        });

        letter.addAll(number);

        return letter.toArray(new String[0]);
    }
}
