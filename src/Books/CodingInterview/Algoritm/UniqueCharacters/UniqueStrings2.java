package src.Books.CodingInterview.Algoritm.UniqueCharacters;

// 고유문자 두번째
public class UniqueStrings2 {
    // a 부터 z 까지만 : 97 ~ 122
    // 중복허용불가: 비트마스크

    private static final char A_CHAR = 'a';

    public static boolean isUnique(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int marker = 0;

        for (int i = 0; i < str.length(); i++) {
            int s = str.charAt(i) - A_CHAR;
            int mask = 1 << s;

            if ((marker & mask) > 0) { // and 연산 했을때 1이 되버리면 중복문자임
                return false;
            }

            marker = marker | mask;
        }

        return true;
    }
}
