package src.LeetCode.String;

// 2409. Count Days Spent Together
// https://leetcode.com/problems/count-days-spent-together/
public class CountDaysSpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int result = 0;

        // 겹치는 구간 체크
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        // 겹치는 구간이 없으면 종료
        if (start.compareTo(end) > 0) {
            return result;
        }

        return dayOfYear(end) - dayOfYear(start) + 1;
    }

    private int dayOfYear(String date) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int result = day;
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }

        return result;
    }
}
