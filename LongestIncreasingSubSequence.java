package leetcode;

/**
 * @Classname LongestIncreasingSubSequence
 * @Description TODO
 * @Date 2020/4/22 15:39
 * @Created by 14241
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS(int[] nums) {
        int[] maxLens=new int[nums.length];
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxLens[i]=Math.max(maxLens[j]+1,maxLens[i]);
                }
            }
            maxLen=Math.max(maxLen,maxLens[i]+1);
        }
        return maxLen;
    }
}
