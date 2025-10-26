package src.LeetCode.Greedy;

// https://leetcode.com/problems/gas-station/description/?envType=problem-list-v2&envId=greedy
public class GasStation {
    // gas[i]: i번 주유소에서 넣을 수 있는 연료량
    // cost[i]: i번 주유소에서 다음 주유소(i+1)까지 가는데 필요한 연료량
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 전체 연료 합 >= 전체 비용 합이면 무족건 존재함
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) { // 음수면 못가는거니 인덱스 업데이트함
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
}
