package src.LeetCode.Greedy;

// 3200. Maximum Height of a Triangle
// https://leetcode.com/problems/maximum-height-of-a-triangle/
public class MaximumHeightOfATriangle {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(simulate(red, blue), simulate(blue, red));
    }

    private int simulate(int a, int b) {
        int height = 0;
        while(true) {
            int row = height + 1;
            if(row % 2 == 1) {
                if (a < row) {
                    break;
                }
                a -= row;
            } else {
                if (b < row) {
                    break;
                }
                b -= row;
            }
            height++;
        }

        return height;
    }
}
