package src.Books.CodingInterview.Recursion.HighestColoredTower;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 메모이제이션 추가
public class HighestColoredTower {
    public static int buildViaMemorization(List<Box> boxes) {
        // 정렬
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return Integer.compare(b2.getWidth(), b1.getWidth());
            }
        });
        
        // 내림차순 정렬
        boxes.forEach(System.out::println);

        int highest = 0;
        int[] cache = new int[boxes.size()];

        for (int i = 0; i < boxes.size(); i++) {
            int height = buildViaMemorization(boxes, i, cache);
            highest = Math.max(highest, height);
        }

        return highest;
    }

    public static int buildViaMemorization(List<Box> boxes, int base, int[] cache) {
        Box current = boxes.get(base);
        int highest = 0;

        for (int i = base; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) { // 상자 배치 가능한지 확인
                int height = buildViaMemorization(boxes, i, cache);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.getHeight();
        cache[base] = highest; // 방문처리

        return highest;
    }
}

class Box {
    private final int width;
    private final int height;
    private final int color;

    public Box(int width, int height, int color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public boolean canBeNext(Box box) {
        if (box == null) {
            return false;
        }

        return ((box.width > this.width) && (box.height > this.height) && (box.color != this.color));
    }

    public int getWidth() {
        return width;
    }

    public int getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Box{" + "width=" + width + ", height=" + height + ", color=" + color + '}';
    }
}
