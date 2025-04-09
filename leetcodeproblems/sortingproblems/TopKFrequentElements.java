package leetcodeproblems.sortingproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
    /**
     * @Leetcode
     * @Important
     * @Medium
     * @347. Top K Frequent Elements
     * @https://leetcode.com/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=sorting
     *
     *
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * */
    public static int[] topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        if(nums.length == k) return nums;

        Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .filter(value -> value.getValue() >= k)
                .forEach(k1->{
                    list.add(k1.getKey());
                });

        return list.stream().mapToInt(i->i).toArray();
    }
    /**
     *
     * @Leetcode solution
     * */
    public static int[] topKFrequent1(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. Build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
