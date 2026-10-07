package src.LeetCode.BFSandDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 3387. Maximize Amount After Two Days of Conversions
// https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/description/
public class MaximizeAmountAfterTwoDaysOfConversions {
    record Edge(String to, double rate) {}

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        // 1일차, 2일차
        // 결과 저장용
        Map<String, Double> day1 = new HashMap<>();
        Map<String, Double> day2 = new HashMap<>();

        dfs(buildGraph(pairs1, rates1), initialCurrency, 1.0, day1);
        dfs(buildGraph(pairs2, rates2), initialCurrency, 1.0, day2);

        double max = 0.0;

        for (Map.Entry<String, Double> entry : day1.entrySet()) {
            String currency = entry.getKey();
            if (!day2.containsKey(currency)) {
                continue;  // 2일차에 못 돌아오면 스킵
            }

            // day2 = 시작 통화 x 환율
            double amount = entry.getValue();
            double rate = day2.get(currency);

            max = Math.max(max, amount / rate);
        }

        return max;
    }

    // 그래프 만들기
    private Map<String, List<Edge>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String,List<Edge>> graph = new HashMap<>();

        for(int i = 0; i < pairs.size(); i++){
            String a = pairs.get(i).get(0);
            String b = pairs.get(i).get(1);

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Edge(b, rates[i]));             // a -> b
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Edge(a, 1.0 / rates[i]));  // b -> a
        }

        return graph;
    }

    private void dfs(Map<String, List<Edge>> graph, String current, double amount, Map<String, Double> result) {
        result.put(current, amount);
        for(Edge edge : graph.getOrDefault(current, List.of())) {
            if (result.containsKey(edge.to)) {
                continue;
            }

            dfs(graph, edge.to, amount * edge.rate, result);
        }
    }
}
