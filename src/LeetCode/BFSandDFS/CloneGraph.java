package src.LeetCode.BFSandDFS;

import java.util.*;

// https://leetcode.com/problems/clone-graph/description/?envType=problem-list-v2&envId=breadth-first-search
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors == null || node.neighbors.isEmpty()) return new Node(node.val);

        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (!map.containsKey(cur)) {
                map.put(cur, new Node(cur.val));
            }

            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    // DFS 로 풀면
    private void dfs(Node node, Map<Node, Node> oldToNew) {
        Node newNode = oldToNew.get(node);

        for (Node next : node.neighbors) {
            if (!oldToNew.containsKey(next)) {
                Node newNext = new Node(next.val);
                oldToNew.put(next, newNext);
                newNode.neighbors.add(newNext);
                dfs(next, oldToNew);
            } else {
                newNode.neighbors.add(oldToNew.get(next));
            }
        }
    }
}


