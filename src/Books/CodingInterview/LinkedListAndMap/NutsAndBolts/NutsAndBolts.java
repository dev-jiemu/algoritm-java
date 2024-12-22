package src.Books.CodingInterview.LinkedListAndMap.NutsAndBolts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NutsAndBolts {
    // 일치하는 모든 너트와 볼트 조합 찾기
    public static void match(char[] nuts, char[] bolts) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }

        for (int i = 0; i < bolts.length; i++) {
            char bolt = bolts[i];
            if (map.containsKey(bolt)) { // 있는지 확인
                nuts[i] = bolts[i];
            } else {
                System.out.println("Bolt " + bolt + " has no nut");
            }
        }

        System.out.println("Matches between nuts and bolts: ");
        System.out.println("Nuts: " + Arrays.toString(nuts));
        System.out.println("Bolts: " + Arrays.toString(bolts));
    }
}
