package src.Programmers.FullSearch;

public class Carpet {

    /*
        yellow 영역은 brown 영역으로 둘러쌓여 있음
        yellow 영역의 가로 길이는 width - 2, 세로 길이는 height - 2

        = width * height = brown + yellow
        = (width - 2) * (height - 2) = yellow

        카펫의 가로길이는 세로 길이와 같거나 길고, yellow가 1인 경우가 최소이므로 width와 height는 3부터 시작한다
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int width = 3; width <= total / 2; width++) {
            if (total % width != 0) { // TC 6, 7, 9 실패:: 약수 구할때 0으로 나누어 떨어지는지 확인
                continue;
            }

            int height = total / width;
            if ((width - 2) * (height - 2) == yellow && width >= height) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int brown = 4004;
        int yellow = 999999;

        Carpet carpet = new Carpet();

        int[] answer = carpet.solution(brown, yellow);
        for (int idx : answer) {
            System.out.println(idx);
        }

    }
}
