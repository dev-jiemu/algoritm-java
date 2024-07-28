package src.Books.CodingInterview.Algoritm.ExtractSurrogatePairs;

import java.util.ArrayList;
import java.util.List;

public class ExtractSurrogatePairs {
    // codePointAt, codePoints, codePointCount, offsetByCodePoints = 자바 서러페이트 페어 관련 메서드
    // chatAt -> codePointAt, chars -> cordPoints

    public static List<Integer> extract(String str) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            if (Character.charCount(cp) == 2) { // i < str.length() - 1 && str.codePointCount(i, i + 2) == 1
                result.add(cp);
                result.add(str.codePointAt(i + 1));
                i++;
            }
        }

        return result;
    }
}
