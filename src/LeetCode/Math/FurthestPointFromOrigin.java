package src.LeetCode.Math;

// 2833. Furthest Point From Origin
// https://leetcode.com/problems/furthest-point-from-origin/description/
public class FurthestPointFromOrigin {
    // 문자열 길이만큼 이동을 다 마쳤을 때 원점(0)으로부터 가장 멀리 떨어질 수 있는 거리 구하기
    // abs(left - right) + space
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int space = 0;
        for(char c : moves.toCharArray()){
            if (c == 'L') {
                left++;
            } else if (c == 'R') {
                right++;
            } else {
                space++;
            }
        }

        return Math.abs(left - right) + space;
    }
}
