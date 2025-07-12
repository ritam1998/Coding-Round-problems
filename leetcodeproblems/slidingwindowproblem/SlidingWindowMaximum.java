package leetcodeproblems.slidingwindowproblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
    /**
     * @Leetcode
     * @SlidingWindow
     *
     * @239. Sliding Window Maximum
     * @https://leetcode.com/problems/sliding-window-maximum/description/?envType=problem-list-v2&envId=sliding-window
     *
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     *
     * Return the max sliding window.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * */
    /**
     *
     * @Algorithm
     *
     * This program uses a Deque (implemented with ArrayDeque in Java) to efficiently keep track of potential maximums within the current window.
     * The Deque stores indices of elements in decreasing order of their values. This way, the element at the front of the Deque is always the maximum for the current window.
     *
     * How it works:
     *
     * Initialization: An ArrayDeque is used to store indices, and an ArrayList stores the results.
     *
     * First Window: The program iterates through the first k elements. For each element, it removes any indices from the back of the Deque whose corresponding values are less than or equal to the current element (because they can no longer be the maximum).
     * Then, the current element's index is added to the back. The maximum of this first window is nums[deque.peekFirst()].
     *
     * Remaining Windows: For subsequent elements, the program performs two main operations:
     *
     * Remove out-of-window elements: It removes indices from the front of the Deque that are no longer part of the current k-sized window.
     *
     * Maintain decreasing order: Similar to the first window, it removes smaller elements from the back and adds the current element's index.
     *
     * The maximum of the current window is always nums[deque.peekFirst()], which is added to the results.
     *
     * This approach ensures that each element is added and removed from the Deque at most once, leading to an optimal time complexity of O(N) where N is the number of elements in the input array.
     * */
    /**
     * Finds the maximum element in each sliding window of size k.
     *
     * @param nums The input array of integers.
     * @param k The size of the sliding window.
     * @return An array containing the maximum element for each sliding window.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || k > nums.length || k <= 0) return new int[]{0};

        /* Deque to store indices of elements.
         * The elements in the deque are stored in decreasing order of their values.
         * The front of the deque will always hold the index of the maximum element
         * in the current window.
         */
        Deque<Integer> indices = new ArrayDeque<>();

        // List to store the results (maximums of each window).
        List<Integer> result = new ArrayList<>();

        for(int start = 0;start < k;start++){

            /* Remove elements from the back of the deque that are smaller than
             * or equal to the current element. These elements are no longer
             * candidates for the maximum as nums[i] is greater and appears later.
             */
            while(!indices.isEmpty() && nums[indices.peekLast()] <= nums[start]) indices.removeLast();

            // Add the current element's index to the back of the deque.
            indices.addLast(start);
        }
        /*
         * After processing the first window, the front of the deque (deque.peekFirst())
         * contains the index of the maximum element in this window.
        * */
        result.add(nums[indices.peekFirst()]);

        /*
         * Process the remaining windows
         * Iterate from k to the end of the array
        * */
        for(int end = k;end < nums.length;end++){

            /**
             * Remove elements from the front of the deque whose indices are
             * outside the current window. The window slides, so elements
             * whose indices are less than (i - k + 1) are no longer part of it.
             * (i - k) is the index of the element that just left the window.
             * */
            while(!indices.isEmpty() && indices.peekFirst() <= (end - k)) indices.removeFirst();

            /**
             * Remove elements from the back of the deque that are smaller than
             * or equal to the current element (nums[i]).
             * */
            while(!indices.isEmpty() && nums[indices.peekLast()] <= nums[end]) indices.removeLast();

            // Add the current element's index to the back of the deque.
            indices.addLast(end);

            // The element at the front of the deque is the maximum for the current window.
            result.add(nums[indices.peekFirst()]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
