package src.LeetCode.Bits;

// 393. UTF-8 Validation
// https://leetcode.com/problems/utf-8-validation/description/
public class UTF8Validation {
    // 문자 하나는 1~4바이트로 표현되고, 각 정수에선 하위 8비트만 의미가 있음
    // 선두 바이트는 앞쪽 1의 개수로 전체 바이트 수가 결정되고 뒤따르는 연속 바이트는 반드시 10으로 시작해야함
    public boolean validUtf8(int[] data) {
        int remaining = 0; // 앞으로 더 와야할 연속 바이트수임

        for(int num : data) {
            int b = num & 0xFF; // 하위 8비트

            if (remaining == 0) {
                // 선두 바이트 체크하기
                if ((b >> 7) == 0b0) { // 1바이트
                    remaining = 0;
                } else if ((b >> 5) == 0b110) { // 2바이트
                    remaining = 1;
                } else if ((b >> 4) == 0b1110) { // 3바이트
                    remaining = 2;
                } else if ((b >> 3) == 0b11110) { // 4바이트
                    remaining = 3;
                } else {
                    return false;
                }
            } else { // 그 외에는 반드시 10으로 시작
                if ((b >> 6) != 0b10) {
                    return false;
                }
                remaining--;
            }
        }

        return remaining == 0; // 잘린 문자 체크
    }
    /*
    remaining 개수를 직접 세는것도 가능함
    if (remaining == 0) {
        int mask = 1 << 7;
        while ((b & mask) != 0) { // 앞에 1 개수 세는거임
            remaining++;
            mask >>= 1;
        }
        if (remaining == 0) continue;          // 1바이트
        if (remaining == 1 || remaining > 4)
            return false;
        remaining--;
    }
     */
}
