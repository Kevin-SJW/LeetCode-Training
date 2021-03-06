package leetcode;

import java.util.*;

/**
 * @Classname LengthOfLIS
 * @Description TODO
 * @Date 2020/4/26 15:40
 * @Created by 14241
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums={1,4,3,4,2,3};
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=0;i< nums.length;i++){
            for(int j=0;j<i;j++){
               if(nums[i]>nums[j]){
                   dp[i]=Math.max(dp[i],dp[j]+1);
               }
            }
        }
        int res=0;
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
