package src.LeetCode.Hash;

import java.util.LinkedHashMap;

// https://leetcode.com/problems/integer-to-roman/description/?envType=problem-list-v2&envId=hash-table
public class IntegerToRoman {
    // LinkedHashMap 쓰면 순서유지됨
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();

        for(Integer value : romanMap.keySet()) {
            while(num >= value) {
                num -= value;
                result.append(romanMap.get(value));
            }
        }

        return result.toString();
    }
}
