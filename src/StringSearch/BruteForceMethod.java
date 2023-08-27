package src.StringSearch;


// 했던 문자열을 또 검사하는 로직이라서(선형 검색을 확장한 알고리즘) 그렇게 효율이 좋지는 못함.
public class BruteForceMethod {

    static int bfMatch(String txt, String pat) {
        int pt = 0; // txt 커서
        int pp = 0; // pat 커서

        while(pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }
}
