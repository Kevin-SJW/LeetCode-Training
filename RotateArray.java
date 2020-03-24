package leetcode;

import java.util.Arrays;

/**
 * @Classname RotateArray
 * @Description TODO
 * @Date 2020/3/24 15:34
 * @Created by 14241
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        Arrays.stream(nums).forEach(System.out::print);
        rotate(nums,k);
        System.out.println();
        Arrays.stream(nums).forEach(System.out::print);

    }
    public static void rotate(int[] nums, int k) {
        int temp,previous=0;
        for(int i=0;i<k;i++){
            previous=nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                temp=nums[j];
                nums[j]=previous;
                previous=temp;
            }
        }
    }
}
