package src.LeetCode.Array;

// https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        
        // 왼쪽 -> 오른쪽으로 한번 쭉 곱하고
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 오른쪽 -> 왼쪽으로 한번 쭉 곱하기
        int rightProduct = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] = result[j] * rightProduct;
            rightProduct *= nums[j];
        }

        return result;
    }
}
