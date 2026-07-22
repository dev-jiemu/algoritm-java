package src.LeetCode.Hash;

import java.util.*;

// 380. Insert Delete GetRandom O(1)
// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class InsertDeleteGetRandom {
    // list + hash 조합으로 쓰면 실제로 list 에 중복된 값이 insert 되더라도 hash 에서 최종 index 만 남아서
    // 결과적으로 O(1) 이 됨 (신박한데? ㅇㅂㅇ?)
    private List<Integer> list;
    private Map<Integer, Integer> valToIndex;
    private Random rand;

    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) { // 중복방지 ㅇㅂㅇ
            return false;
        }

        valToIndex.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        int idx = valToIndex.get(val);
        int lastVal = list.get(list.size() - 1);

        // 삭제할 요소를 리스트 마지막으로 보내서 지워버림 ㅇㅂㅇ
        list.set(idx, lastVal);
        valToIndex.put(lastVal, idx);
        list.remove(list.size() - 1);
        valToIndex.remove(val);

        return true;
    }

    // 랜덤으로 아무거나
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}


