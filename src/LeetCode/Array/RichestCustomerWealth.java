package src.LeetCode.Array;

// 1672. Richest Customer Wealth
// https://leetcode.com/problems/richest-customer-wealth/description/
public class RichestCustomerWealth {
    // m, n 이 최대 50이란 제약조건이 있으므로 2중 for 문 돌려도 크게 이슈 없을듯 ㅇㅂㅇ
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int money : customer) {
                wealth += money;
            }
            result = Math.max(result, wealth);
        }

        return result;
    }
}
