package leetcode;

/**
 * @Classname MinimumSizeSubarraySum
 * @Description TODO
 * @Date 2020/3/30 15:54
 * @Created by 14241
 * 用一个指针维护左边界即可
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s,nums));

    }
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum=0,left=0,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=s){
                min=Math.min(min,i-left+1);
                sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
