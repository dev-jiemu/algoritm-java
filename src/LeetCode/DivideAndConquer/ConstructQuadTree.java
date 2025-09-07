package src.LeetCode.DivideAndConquer;

// https://leetcode.com/problems/construct-quad-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    // 전체 영역의 값을 확인해서 -> 다르면 분할 -> 재귀로 분할처리
    // 다 같으면 leafNode (isLeaf true)
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private Node buildQuadTree(int[][] grid, int row, int col, int size) {
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int halfSize = size / 2;
        Node node = new Node(false, false);

        node.topLeft = buildQuadTree(grid, row, col, halfSize);
        node.topRight = buildQuadTree(grid, row, col + halfSize, halfSize);
        node.bottomLeft = buildQuadTree(grid, row + halfSize, col, halfSize);
        node.bottomRight = buildQuadTree(grid, row + halfSize, col + halfSize, halfSize);

        return node;
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int firstValue = grid[row][col];

        for(int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != firstValue) {
                    return false; // 다름
                }
            }
        }

        return true;
    }
}
