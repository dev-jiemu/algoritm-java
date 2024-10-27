package src.Books.CodingInterview.Algoritm.PetrolBunks;


// 전체 주유소를 방문하기 위한 트럭이 출발해야하는 첫번째 지점 찾기
// not 브루트 포스
public class PetrolBunks {
    
    // x 주유소에서 y 주유소로 갈때 거리보다 주유량이 많아야함...
    public static int circularTour(int[] fuel, int[] dist) {
        int sumRemainingFuel = 0;
        int totalFuel = 0;
        int start = 0;

        for(int i = 0; i < fuel.length; i++) {
            int remainingFuel = fuel[i] - dist[i];

            if (sumRemainingFuel >= 0) {
                sumRemainingFuel += remainingFuel;
            } else {
                sumRemainingFuel = remainingFuel;
                start = i;
            }

            totalFuel += remainingFuel;
        }

        if (totalFuel >= 0) { // 0보다 크면 갈수 있는거임
            return start;
        }

        return -1; // 못감
    }

}
