package leetcode;

import java.util.Arrays;

/**
 * @Classname WiggleSort2
 * @Description TODO
 * @Date 2020/5/10 16:38
 * @Created by 14241
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 */
public class WiggleSort2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        Arrays.stream(nums).forEach(t -> System.out.print(t + " "));
        wiggleSort(nums);
        System.out.println();
        Arrays.stream(nums).forEach(t -> System.out.print(t + " "));

    }

    public static void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int minIdx = (nums.length & 1) == 1 ? nums.length >> 1 : (nums.length >> 1) - 1;
        int maxIdx = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i += 2) {
            nums[i] = copy[minIdx--];
            nums[i + 1] = copy[maxIdx--];
        }
        if ((nums.length & 1) == 1) {
            nums[nums.length - 1] = copy[minIdx--];
        }

    }
}
