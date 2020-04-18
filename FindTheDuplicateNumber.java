package leetcode;

import java.util.Arrays;

/**
 * @Classname FindTheDuplicateNumber
 * @Description TODO
 * @Date 2020/4/18 15:40
 * @Created by 14241
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
