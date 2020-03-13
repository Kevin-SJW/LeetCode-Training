package leetcode;

/**
 * @Classname FindMinimumInRotatedSortedArray
 * @Description TODO
 * @Date 2020/3/13 15:50
 * @Created by 14241
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                if (nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
