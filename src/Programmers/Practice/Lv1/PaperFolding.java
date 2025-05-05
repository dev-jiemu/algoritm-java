package src.Programmers.Practice.Lv1;

// 지폐 접기
// https://school.programmers.co.kr/learn/courses/30/lessons/340199
public class PaperFolding {

    public static void main(String[] args) {
        int[] wallet = new int[]{30, 15};
        int[] bill = new int[]{26, 17};

        int result = new PaperFolding().solution(wallet, bill);
        System.out.println("result : " + result);
    }

    // 접을땐 꼭 긴쪽을 반으로 접음 ㅇㅇ + 소수점 버림 (int)
    // 회전 : x, y 바꿔서 계산
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int wallet1 = Math.max(wallet[0], wallet[1]);
        int wallet2 = Math.min(wallet[0], wallet[1]);

        int bill1 = bill[0];
        int bill2 = bill[1];

        // 이미 들어갈수 있으면 패스
        if ((wallet1 >= bill1 && wallet2 >= bill2) || (wallet1 >= bill2 && wallet2 >= bill1)) {
            return answer;
        }

        while(true) {
            if (bill1 > bill2) {
                bill1 = bill1 / 2;
            } else {
                bill2 = bill2 / 2;
            }

            answer++;

            if((wallet1 >= bill1 && wallet2 >= bill2) || (wallet2 >= bill1 && wallet1 >= bill2)) {break;}

            // 무한루프 방지
            if(bill1 <= 1 && bill2 <= 1) {break;}
        }

        return answer;
    }

}
