package leetcode;

/**
 * @Classname FindMinimumInRotatedSortedArray2
 * @Description TODO
 * @Date 2020/3/14 15:53
 * @Created by 14241
 *
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(findMin(nums)+" ");

    }

    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //如果nums[left] > nums[mid]，说明存在left，mid降序
            if (nums[left] > nums[mid]) {
                left++;
                right = mid;
                //如果nums[mid] > nums[right]，说明存在mid，right降序
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                //不存在降序，说明有重复元素，把数组长度缩短1；
                right--;
            }
        }
        return nums[left];
    }
}
