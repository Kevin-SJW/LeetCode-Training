package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RemoveDuplicates
 * @Description Given a sorted array nums, remove the duplicates
 * in-place such that each element appear only once and return
 * the new length.
 * @Date 2019/11/5 14:46
 * @Created by 14241
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];

            }
        }
        return i + 1;
    }
}
