package src.LeetCode.Array;

// 1620. Coordinate With Maximum Network Quality
// https://leetcode.com/problems/coordinate-with-maximum-network-quality/description/
public class CoordinateWithMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int bestQuality = 0;
        int bestX = 0;
        int bestY = 0;

        int r2 = radius * radius;

        // 제약조건이 크진 않네 ㅇㅂㅇ
        for(int x = 0; x <= 50; x++) {
            for(int y = 0; y <= 50; y++) {
                int quality = 0;

                for(int[] t : towers) {
                    int dx = x - t[0];
                    int dy = y - t[1];

                    int d2 = dx * dx + dy * dy;

                    // 반경 이내 체크
                    if(d2 <= r2) {
                        quality += (int) (t[2] / (1 + Math.sqrt(d2)));
                    }
                }

                if(quality > bestQuality) {
                    bestQuality = quality;
                    bestX = x;
                    bestY = y;
                }
            }
        }

        return new int[]{bestX, bestY};
    }
}
