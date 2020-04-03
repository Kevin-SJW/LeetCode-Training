package leetcode;

import java.util.Arrays;

/**
 * @Classname ContainsDuplicate
 * @Description TODO
 * @Date 2020/4/3 15:27
 * @Created by 14241
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears
 * at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
