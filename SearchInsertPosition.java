package leetcode;

/**
 * @Classname SearchInsertPosition
 * @Description TODO
 * @Date 2019/11/20 14:47
 * @Created by 14241
 */
public class SearchInsertPosition {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            return l;
        }

        return 0;
    }
}
