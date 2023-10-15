package src.Programmers.Array;

import java.util.*;

public class HIndex {

    /*
        H-Index = max(min(citations[i], n-i)) for i in 0 to n
        hint : https://school.programmers.co.kr/learn/courses/14743/lessons/118838
        Ref : https://blog.naver.com/gkswlcjs2/223022223410
     */
    public int solution(int[] citations) {
        int answer = 0;

        // 내림차순 정렬
        Arrays.sort(citations);
        int[] reversedArr = new int[citations.length];
        for (int i = 0; i < citations.length; i++) {
            reversedArr[i] = citations[citations.length - 1 - i];
        }

        int index = 0;
        while (index < reversedArr.length && reversedArr[index] >= index + 1) {
            answer = Math.min(reversedArr[index], index + 1);
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 4};
        HIndex hIndex = new HIndex();

        int result = hIndex.solution(citations);
        System.out.println("result : " + result);
    }
}
