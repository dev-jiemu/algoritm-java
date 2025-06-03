package src.LeetCode.Array;

// https://leetcode.com/problems/can-place-flowers/submissions/1652270010/?envType=study-plan-v2&envId=leetcode-75
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;

                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }
}
