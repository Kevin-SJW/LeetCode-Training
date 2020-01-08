package leetcode;

/**
 * @Classname ClimbingStairs
 * @Description TODO
 * @Date 2020/1/8 15:05
 * @Created by 14241
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs(n));

    }
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
