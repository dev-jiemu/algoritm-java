package src.Programmers.Practice.Lv1;

import java.util.ArrayList;
import java.util.Arrays;

// 택배 상자 꺼내기
// https://school.programmers.co.kr/learn/courses/30/lessons/389478
public class DeliveryBoxUnpacker {

    public static void main(String[] args) {
        int n = 13;
        int w = 3;
        int num = 6;

        int result = new DeliveryBoxUnpacker().solution(n, w, num);
        System.out.println(result);
    }

    // w = 한줄 개수
    // n = 전체 개수
    public int solution(int n, int w, int num) {
        int answer = 0;

        // 전체 list 개수 구해야함
        int size = (int)Math.ceil((double)n / w);
        ArrayList<int[]> lines = new ArrayList<>();

        boolean reverse = false;
        int number = 1;
        for (int i = 0; i < size; i++) {
            int[] line = new int[w];
            Arrays.fill(line, -1); // default -1 (비어있음을 의미)

            int start = reverse ? w - 1 : 0;
            int end = reverse ? -1 : w;
            int step = reverse ? -1 : 1;

            for (int j = start; j != end; j += step) {
                if (number <= n) {
                    line[j] = number++;
                } else {
                    break;
                }
            }

            lines.add(line);
            reverse = !reverse;
        }

        // 인덱스 찾기
        int search = ((num - 1) / w + 1) - 1;
        int[] line = lines.get(search);

        int index = 0;
        for (int i = 0; i < w; i++) {
            if (line[i] == num) {
                index = i;
            }
        }

        for (int i = search; i < lines.size(); i++) {
            int[] current = lines.get(i);
            if (current[index] != -1) {
                answer++;
            }
        }

        return answer;
    }
}
