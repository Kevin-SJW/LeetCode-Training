package leetcode;

import java.util.Arrays;

/**
 * @Classname MoveZeroes
 * @Description TODO
 * @Date 2020/4/17 15:56
 * @Created by 14241
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        Arrays.stream(nums).forEach(t-> System.out.print(t+" "));
        moveZeroes(nums);
        System.out.println();
        Arrays.stream(nums).forEach(t-> System.out.print(t+" "));


    }
    public static void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        while(j<nums.length){
            nums[j++]=0;
        }
    }
}
