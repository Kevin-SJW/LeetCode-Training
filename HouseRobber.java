package leetcode;

/**
 * @Classname HouseRobber
 * @Description TODO
 * @Date 2020/3/25 15:55
 * @Created by 14241
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));

    }
    public static int rob(int[] nums) {
        int t0=0;
        int t1=0;
        for(int i=0;i<nums.length;i++){
            int temp=t0;
            t0=Math.max(t0,t1);
            t1=temp+nums[i];
        }
        return Math.max(t0,t1);
    }
}
