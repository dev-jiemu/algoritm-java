package src.Books.CheetSheetWithLeetCode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String s : deadends) {
            deads.add(s);
        }
        
        // 이미 처리한 번호
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        
        int step = 0;
        queue.add("0000");
        visited.add("0000");

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                if (deads.contains(current)) continue;
                if (current.equals(target)) return step;

                for(int j = 0; j < 4; j++) {
                    String up = plusOne(current, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }

                    String down = minusOne(current, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if(ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }

        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if(ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }

        return new String(ch);
    }

}
