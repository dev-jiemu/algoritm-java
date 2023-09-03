package src.StringSearch;

// 보이어 무어 법
public class BoyerAndMoore {
    static int BmMatch(String txt, String pat) {
        int pt, pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        // 표만들기
        for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0; pt < patLen; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }

        while (pt < txtLen) {
            pp = patLen -1; // 마지막 문자

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }

        return -1;
    }
}
