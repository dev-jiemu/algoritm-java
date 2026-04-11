package src.Programmers.Greedy;

// 조이스틱
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class Joystick {
    public int solution(String name) {
        int length = name.length();

        // 이전 문자열 위치 (위, 아래)
        int move = 0;
        for(char c : name.toCharArray()) {
            move += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 좌, 우 이동 체크
        int right = length - 1; // 오른쪽으로만 끝까지 감
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') { // A 인거 끝에 찾기
                next++;
            }

            right = Math.min(right, i + (length - next) + Math.min(i, length - next));
        }

        return move + right;
    }
}
