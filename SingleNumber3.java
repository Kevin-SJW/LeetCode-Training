package leetcode;

import java.util.Arrays;

/**
 * @Classname SingleNumber3
 * @Description TODO
 * @Date 2020/4/13 15:54
 * @Created by 14241
 * Given an array of numbers nums, in which exactly two elements appear
 * only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        Arrays.stream(singleNumber(nums)).forEach(t-> System.out.print(t+" "));
//        System.out.println(singleNumber(nums));

    }
    public static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int array[] = new int[2];
        int count=0;
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                array[count++]=nums[i];
                i-=1;
            }
        }
        if(count==1){
            array[1]=nums[nums.length-1];
        }
        return array;
    }
}
