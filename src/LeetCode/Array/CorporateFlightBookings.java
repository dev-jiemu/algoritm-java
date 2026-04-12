package src.LeetCode.Array;

// 1109. Corporate Flight Bookings
// https://leetcode.com/problems/corporate-flight-bookings/description/
public class CorporateFlightBookings {
    // 차분배열
    // Ref. https://sheep1sik.tistory.com/161
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];  // 인덱스 0번부터 n + 1 까지 체크할거라서 2개 더 추가

        for (int[] b : bookings) {
            diff[b[0]] += b[2];
            diff[b[1] + 1] -= b[2]; // b[1] 의 다음 인덱스에 빼주기
        }

        int[] answer = new int[n];
        answer[0] = diff[1];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + diff[i+1];
        }

        return answer;
    }
}
