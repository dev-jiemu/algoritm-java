package src.LeetCode.Bits;

import java.util.HashMap;
import java.util.Map;

// 1386. Cinema Seat Allocation
// https://leetcode.com/problems/cinema-seat-allocation/description/
public class CinemaSeatAllocation {
    // 1이랑 10은 볼 필요없음
    // 좌석 4개씩은 bitmask 로 비교해서 판별
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMask = new HashMap<>();

        for(int[] rs : reservedSeats) {
            int row = rs[0];
            int seat = rs[1];

            if (seat < 2 || seat > 9) {
                continue; // 1, 10은 건너뜀
            }

            int bit = 1 << (seat - 2);
            rowMask.put(row, rowMask.getOrDefault(row, 0) | bit);
        }

        int block1 = 0b00001111; // 좌석 2,3,4,5
        int block2 = 0b00111100; // 좌석 4,5,6,7
        int block3 = 0b11110000; // 좌석 6,7,8,9

        int result = 0;

        // 예약이 있는 행만 계산함
        for(int mask : rowMask.values()) {
            if ((mask & block1) == 0 && (mask & block3) == 0) { // 두개 다 비어있으면 둘다 배정 가능
                result += 2;
            } else if ((mask & block1) == 0 || (mask & block2) == 0 || (mask & block3) == 0) { // 셋 중 하나 비어있으면 배정 가능
                result += 1;
            }
        }

        // 예약이 전혀 없는행 = (전체 행수 - 예약 있는 행수) x 2
        int empty = n - rowMask.size();
        result += empty * 2;

        return result;
    }
}
