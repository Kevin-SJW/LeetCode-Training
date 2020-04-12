package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname SlidingWindowMaxisum
 * @Description TODO
 * @Date 2020/4/12 15:20
 * @Created by 14241
 * Given an array nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window
 * moves right by one position. Return the max sliding window.
 */
public class SlidingWindowMaxisum {
    public static void main(String[] args) {
        int[] num={1,3,-1,-3,5,3,6,7};
        int k=3;
        Arrays.stream(maxSlidingWindow(num, k)).forEach(s-> System.out.print(s+" "));

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            queue.add(-nums[i]);
        }
        int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            queue.add(-nums[j]);
            max[i] = -queue.peek();
            queue.remove(-nums[j - k + 1]);
        }
        return max;
    }
}
