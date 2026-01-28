package src.LeetCode.BFSandDFS;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        queue.add(startGene);
        visited.add(startGene); // 방문처리
        int mutation = 0;

        char[] genes = {'A', 'C', 'G', 'T'};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                if (endGene.equals(current)) {
                    return mutation;
                }

                for(int pos = 0; pos < 8; pos++) {
                    // 4개 문자 각각 변경
                    for(char gene : genes) {
                        char[] arr = current.toCharArray();
                        arr[pos] = gene;
                        String newStr = new String(arr);

                        if (bankSet.contains(newStr) && !visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }

            mutation++;
        }

        return -1;
    }
}
