package leetcode;

import java.util.Arrays;

/**
 * @Classname ProductOfArrayExceptItself
 * @Description TODO
 * @Date 2020/5/22 16:20
 * @Created by Administrator
 * Given an array nums of n integers where n > 1,  return an array output
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        Arrays.stream(productExceptSelf(nums)).forEach(t-> System.out.print(t+"　"));


    }
    public static int[] productExceptSelf(int[] nums){
        int[] res=new int[nums.length];
        int left=1;
        // 从左往右遍历
        for(int i=0;i<nums.length;i++){
            res[i]=left;
            left=nums[i]*left;
        }
        int right=1;
        // 从右往左遍历
        for(int j=nums.length-1;j>=0;j--){
            res[j]*=right;
            right=nums[j]*right;
        }
        return res;
    }



}
