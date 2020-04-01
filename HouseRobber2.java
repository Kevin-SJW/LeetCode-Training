package leetcode;

/**
 * @Classname HouseRobber2
 * @Description TODO
 * @Date 2020/4/1 15:40
 * @Created by 14241
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums={2,3,2};
        System.out.println(rob(nums));

    }
    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        return Math.max(rob(nums,0,nums.length-1),
                rob(nums,1,nums.length));

    }
    public static int rob(int[] nums,int begin,int end){
        int pre1=0;
        int pre2=0;
        int temp=0;
        for(int i=begin;i<end;i++){
            temp=Math.max(nums[i]+pre2,pre1);
            pre2=pre1;
            pre1=temp;
        }
        return temp;
    }
}
