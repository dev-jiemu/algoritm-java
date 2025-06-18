package src.LeetCode.TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int result = 0;

        while(left < right){
            // 너비 : right - left
            // 높이 : Min(height[left], height[right])
            int water = (right - left) * Math.min(height[left], height[right]);

            result = Math.max(water, result);

            // FIX : 생각해보니 다음 인덱스값이 직전 인덱스보다 작으면 건너뛰어도 됨
            if (height[left] < height[right]) {
                int currentLeft = height[left];
                while(left < right && height[left] <= currentLeft){
                    left++;
                }
            } else {
                int currentRight = height[right];
                while(right > left && height[right] <= currentRight){
                    right--;
                }
            }
        }

        return result;
    }
}
