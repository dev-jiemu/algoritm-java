package src.Books.CodingInterview.Algoritm.ExtractIntegers;

import java.util.ArrayList;
import java.util.List;

// 10.2.6 정수 추출하기
public class ExtractIntegers {
    // 아스키코드 48 ~ 97 이하 코드 추출
    public static List<Integer> extract(String str) {
        List<Integer> result = new ArrayList<>();

        StringBuilder temp = new StringBuilder(String.valueOf(Integer.MAX_VALUE).length());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // if (((int) ch) >= 48 && ((int) ch >= 57))
            if (Character.isDigit(ch)) {
                temp.append(ch);
            } else {
                if (temp.length() > 0) {
                    result.add(Integer.parseInt(temp.toString())); // 숫자만 있는 object 추가
                    temp.delete(0, temp.length());
                }
            }
        }

        return result;
    }
}
