package src.Programmers.FullSearch;

public class SmallestRectangle {

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int currentWidth = size[0];
            int currentHeight = size[1];

            // 가로보다 세로가 더 길다면 서로 교환
            if (currentWidth < currentHeight) {
                int temp = currentWidth;
                currentWidth = currentHeight;
                currentHeight = temp;
            }

            if (maxWidth < currentWidth) {
                maxWidth = currentWidth;
            }

            if (maxHeight < currentHeight) {
                maxHeight = currentHeight;
            }
        }

        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        SmallestRectangle smallestRectangle = new SmallestRectangle();

        int result = smallestRectangle.solution(sizes);
        System.out.println("result : " + result);
    }
}
