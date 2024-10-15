package src.Books.CodingInterview.Algoritm.ContainerMostWater;

// 최대 면적을 갖는 직사각형을 찾는다고 생각하면 될듯
public class Containers {

    // 일방적인 방법 : 이중 for 문
    public static int maxArea(int[] heights) {
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                result = Math.max(result, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return result;
    }
    
    // 투 포인터 방식으로 하면 위의 방식보다 간결해짐
    public static int maxAreaOptimized(int[] heights) {
        int result = 0;

        // 왼쪽, 오른쪽 포인터
        int i = 0;
        int j = heights.length - 1;

        while(i < j) {
            result = Math.max(result, Math.min(heights[i], heights[j]) * (j - i));

            // 상대적으로 작은 쪽의 포인터를 이동시킴
            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}
