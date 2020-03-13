package leetcode;

/**
 * @Classname MaxisumProductSubArray
 * @Description TODO
 * @Date 2020/3/13 15:28
 * @Created by 14241
 * Given an integer array nums, find the contiguous subarray within
 * an array (containing at least one number) which has the largest product.
 */
public class MaxisumProductSubArray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        System.out.println(maxProduct(nums));

    }
    public static int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int localMax=nums[0];
        int localMin=nums[0];
        int globalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=localMax;
            localMax=Math.max(Math.max(temp*nums[i],nums[i]),localMin*nums[i]);
            localMin=Math.min(Math.min(localMin*nums[i],nums[i]),temp*nums[i]);
            globalMax=Math.max(localMax,globalMax);
        }
        return globalMax;
    }
}
