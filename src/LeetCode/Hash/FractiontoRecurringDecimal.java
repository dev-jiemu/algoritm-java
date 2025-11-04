package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fraction-to-recurring-decimal/?envType=problem-list-v2&envId=hash-table
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) { return "0"; }

        StringBuilder result = new StringBuilder();

        // 음수처리
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 정수
        result.append(num / den);
        long remainder = num % den; // 나머지

        if (remainder == 0) { return result.toString(); }

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // 순환 발견
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }


        return result.toString();
    }
}
