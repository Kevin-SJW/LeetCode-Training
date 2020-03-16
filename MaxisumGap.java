package leetcode;

import java.util.Arrays;

/**
 * @Classname MaxisumGap
 * @Description TODO
 * @Date 2020/3/16 16:08
 * @Created by 14241
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 * 找最大差值,先排序，后比较
 */
public class MaxisumGap {
    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(maximumGap(nums));

    }
    public static int maximumGap(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int difference=0;
        for(int i=1;i<nums.length;i++){
            if(difference<nums[i]-nums[i-1]){
                    difference=nums[i]-nums[i-1];
            }
        }
        return difference;
    }
}
