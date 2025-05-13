package src.LeetCode.Hash;

import java.util.*;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
public class FindtheDifferenceofTwoArrays {
    // Hash map, set 활용하면
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, Integer> nums1Map = new HashMap<>();
        HashMap<Integer, Integer> nums2Map = new HashMap<>();

        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1); // 사실 의미없는 count 임
        }
        for (int num : nums2) {
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> commonKeys = new HashSet<>();
        for (Integer key : nums1Map.keySet()) {
            if (nums2Map.containsKey(key)) {
                commonKeys.add(key);
            }
        }

        // 발견된 공통 키를 양쪽 맵에서 제거
        for (Integer key : commonKeys) {
            nums1Map.remove(key);
            nums2Map.remove(key);
        }

        result.add(new ArrayList<>(nums1Map.keySet()));
        result.add(new ArrayList<>(nums2Map.keySet()));

        return result;
    }
}
