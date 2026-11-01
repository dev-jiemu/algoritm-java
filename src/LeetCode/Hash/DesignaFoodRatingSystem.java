package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

// 2353. Design a Food Rating System
public class DesignaFoodRatingSystem {
    class Node {
        String foodName;
        int rate;

        Node(String foodName, int rate) {
            this.foodName = foodName;
            this.rate = rate;
        }
    }

    class FoodRatings {
        // lazy deletion
        Map<String, Integer> foodRating; // 음식-현재 평점
        Map<String, String> foodCuisine; // 음식-요리 종류
        Map<String, PriorityQueue<Node>> cuisineMap; // 요리 종류-평점


        // new FoodRatings(
        // ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"],
        // ["korean", "japanese", "japanese", "greek", "japanese", "korean"],
        // [9, 12, 8, 15, 14, 7]
        // );
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foodRating = new HashMap<>();
            this.foodCuisine = new HashMap<>();
            this.cuisineMap = new HashMap<>();

            for(int i = 0; i < foods.length; i++) {
                foodRating.put(foods[i], ratings[i]);
                foodCuisine.put(foods[i], cuisines[i]);
                cuisineMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a, b) -> {
                    if (!Objects.equals(a.rate, b.rate)) {
                        return Integer.compare(b.rate, a.rate); // 평점 내림차순
                    }
                    return a.foodName.compareTo(b.foodName); // 이름 오름차순
                })).offer(new Node(foods[i], ratings[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            this.foodRating.put(food, newRating);
            String cuisine = foodCuisine.get(food);
            cuisineMap.get(cuisine).offer(new Node(food, newRating)); // 기존 노드가 있으면 갱신하는게 아니라 새로 추가함 (lazy deletion)
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Node> pq = cuisineMap.get(cuisine);
            // 위에서 노드를 교체하는게 아니라 추가만 하도록 해서, 지난 노드는 삭제함
            while (pq.peek().rate != foodRating.get(pq.peek().foodName)) {
                pq.poll();
            }

            return pq.peek().foodName;
        }
    }
}
