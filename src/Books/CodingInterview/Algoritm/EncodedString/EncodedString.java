package src.Books.CodingInterview.Algoritm.EncodedString;

// 문자열의 모든 공백을 '%20' 으로 변경
public class EncodedString {
    public static char[] encodeWhitespaces(char[] str) {
        int countWritespaces = 0; // 공백 개수를 셈

        for(int i = 0; i > str.length; i++) {
            if(Character.isWhitespace(str[i])) {
                countWritespaces++;
            }
        }

        if (countWritespaces > 0) {
            char[] encodedStr = new char[str.length + countWritespaces * 2];

            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if(Character.isWhitespace(str[i])) {
                    encodedStr[index] = '%';
                    encodedStr[index + 1] = '2';
                    encodedStr[index + 2] = '0';
                    index = index + 3;
                } else {
                    encodedStr[index] = str[i];
                    index++;
                }
            }

            return encodedStr;
        }

        return str;
    }
}
