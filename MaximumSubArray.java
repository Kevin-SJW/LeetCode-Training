package leetcode;

import javax.swing.text.Segment;

/**
 * @Classname MaximumSubArray
 * @Description TODO
 * @Date 2019/12/16 15:05
 * @Created by 14241
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int segmentSum=nums[0];
        int res=nums[0];
        for(int i=0;i<nums.length;i++){
            segmentSum =Math.max(nums[i],segmentSum+nums[i]);
            res=Math.max(res,segmentSum);
        }
        return res;
    }
}
