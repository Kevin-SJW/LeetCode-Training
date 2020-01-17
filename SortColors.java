package leetcode;

import java.util.Arrays;

/**
 * @Classname SortColors
 * @Description TODO
 * @Date 2020/1/17 18:17
 * @Created by 14241
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        Arrays.stream(nums).forEach(System.out::print);
        sortColors(nums);
        System.out.println();
        Arrays.stream(nums).forEach(System.out::print);

    }
    public static void sortColors(int[] nums) {
        int i=0;
        int end=nums.length-1;
        int start=0;
        while(i<=end){
            //将数组交换到0前面
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[start];
                nums[start]=tmp;
                i++;
                start++;

                //将数组交换到2后面
            }else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[end];
                nums[end]=temp;
                end--;
                //跳过
            }else{
                i++;
            }
        }
    }
}
