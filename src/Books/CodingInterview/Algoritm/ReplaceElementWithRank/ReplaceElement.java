package src.Books.CodingInterview.Algoritm.ReplaceElementWithRank;

import java.util.Map;
import java.util.TreeMap;

public class ReplaceElement {
    // 요소 순위로 변환
    // tree map
    public static void replace(int[] m) {
        Map<Integer, Integer> treemap = new TreeMap<>();

        for (int i = 0; i < m.length; i++) {
            treemap.put(m[i], i);
        }

        int rank = 1;

        // 순위 변경
        for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            m[entry.getValue()] = rank++;
        }
    }
}
