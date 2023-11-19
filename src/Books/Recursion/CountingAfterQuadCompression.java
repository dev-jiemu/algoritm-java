package src.Books.Recursion;

public class CountingAfterQuadCompression {
    // offsetX, offsetY, size
    // 좌표 (offsetX, offsetY) 에서 시작해서 가로 길이와 세로 길이가 size인 정사각형을 압축했을 때 남아있는 0과 1의 개수

//    점화식
//    (offsetX, offsetY, size) = (offsetX, offsetY, size/2)
//    + (offsetX + size/2, offsetY, size/2)
//    + (offsetX, offsetY + size/2, size/2)
//    + (offsetX + size/2, offsetY + size/2, size/2)
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }

    public Count count(int offsetX, int offsetY, int size, int[][] arr) {

        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }


        // 재귀 종료조건: 정사각형 안의 모든 원소가 다 같은 값일 때
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }
}

class Count {
    public int zero;
    public int one;

    public Count(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }

    public Count add(Count other) {
        return new Count(zero + other.zero, one + other.one);
    }
}