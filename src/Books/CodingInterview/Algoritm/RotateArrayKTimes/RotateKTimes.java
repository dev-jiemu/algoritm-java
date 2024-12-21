package src.Books.CodingInterview.Algoritm.RotateArrayKTimes;

public class RotateKTimes {
    // K번째 배열 회전
    public static void rightRotate(int[] m, int k) {
        int[] cm = m.clone();

        for(int i = 0; i < m.length; i++) {
            m[(i + k) % m.length] = cm[i]; // 나머지 연산
        }
    }
}
