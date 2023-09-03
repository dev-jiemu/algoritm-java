package src.StringSearch;

// KMP 법
// 근데 이건 전진만 하지 후진을 할수가 없는 구조인데?
public class KmpMatch {
    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[txt.length() + 1]; // 건너뛰기 표

        // 표만들기
        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while(pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }

        if(pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }
}
