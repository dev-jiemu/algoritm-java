package src.LeetCode.Bits;

import java.util.ArrayList;
import java.util.List;

// 89. Gray Code
// https://leetcode.com/problems/gray-code/description/
public class GrayCode {
    public List<Integer> grayCode(int n) {
        // 겹치지 않는거만 찾으면 되니까 hash 를 사용 안하는게 효율적일줄 알았는데, 이미 수학적으로 겹치지 않는다고 증명이 되었다나 ㅇㅂㅇ
        // feat. Claude
        // 보니까 맞긴 하네
        /*
            i ^ (i >> 1) 공식은 수학적으로 이미 중복이 발생하지 않음이 증명된 공식이야.
            n=3 일 때 (0~7)
            i=0: 0 ^ 0 = 000 = 0
            i=1: 1 ^ 0 = 001 = 1
            i=2: 2 ^ 1 = 011 = 3
            i=3: 3 ^ 1 = 010 = 2
            i=4: 4 ^ 2 = 110 = 6
            i=5: 5 ^ 2 = 111 = 7
            i=6: 6 ^ 3 = 101 = 5
            i=7: 7 ^ 3 = 100 = 4
         */

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
