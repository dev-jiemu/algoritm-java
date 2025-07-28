package src.LeetCode.Bits;

import java.math.BigInteger;

// https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
public class AddBinary {
    public String addBinary(String a, String b) {
        BigInteger numA = new BigInteger(a, 2);
        BigInteger numB = new BigInteger(b, 2);

        while (!numB.equals(BigInteger.ZERO)) {
            BigInteger carry = numA.and(numB); // AND
            numA = numA.xor(numB); // XOR
            numB = carry.shiftLeft(1);
        }

        return numA.toString(2);
    }

    /*
     * BigInteger 는 내장 라이브러리 쓰는거라 이게 더 효율적이긴 함
     *
     * public String addBinary(String a, String b) {
     *     StringBuilder result = new StringBuilder();
     *     int i = a.length() - 1;
     *     int j = b.length() - 1;
     *     int carry = 0;
     *
     *     while (i >= 0 || j >= 0 || carry > 0) {
     *         int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
     *         int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
     *
     *         int sum = bitA ^ bitB ^ carry;
     *         carry = (bitA & bitB) | (carry & (bitA ^ bitB));
     *
     *         result.append(sum);
     *         i--;
     *         j--;
     *     }
     *
     *     return result.reverse().toString();
     * }
     */
}
