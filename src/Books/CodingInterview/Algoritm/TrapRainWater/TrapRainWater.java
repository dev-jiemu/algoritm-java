package src.Books.CodingInterview.Algoritm.TrapRainWater;

public class TrapRainWater {
    
    // 막대를 순회하면서 왼쪽/오른쪽에서 가장 높은 막대를 찾으면 됨
    // 1. 최솟값이 현대 막대보다 낮으면 빗물이 없음
    // 2. 최솟값이 현재 막대보다 높으면 최솟값과 높이 차이만큼 모을 수 있음
    public static int trapViaArray(int[] bars) {
        int water = 0;

        int n = bars.length - 1;

        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], bars[i - 1]);
        }

        int right = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 1; i--) {
            right = Math.max(right, bars[i - 1]);

            if (Math.min(left[i],right) > bars[i]) {
                water += Math.min(left[i], right) - bars[i];
            }
        }

        return water;
    }
    
    // 투포인터로 풀어보기
    public static int trapOptimized(int[] bars) {
        int water = 0;

        int left = 0;
        int right = bars.length - 1;
        int maxBarLeft = bars[left];
        int maxBarRight = bars[right];

        while(left < right) {
            if (bars[left] <= bars[right]) {
                left++;
                maxBarLeft = Math.max(maxBarLeft, bars[left]);
                water += (maxBarLeft - bars[left]);
            } else {
                right--;
                maxBarRight = Math.max(maxBarRight, bars[right]);
                water += (maxBarRight - bars[right]);
            }
        }

        return water;
    }
}
