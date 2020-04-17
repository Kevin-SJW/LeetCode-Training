package leetcode;

/**
 * @Classname PerfectSquares
 * @Description TODO
 * @Date 2020/4/17 15:31
 * @Created by 14241
 * Given a positive integer n, find the least number
 * of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 */
public class PerfectSquares {
    public static void main(String[] args) {
        int n=12;
        System.out.println(numSquares(n));

    }
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        if(n==0){
            return 0;
        }
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){

                min=Math.min(min,dp[i-j*j]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }
}
