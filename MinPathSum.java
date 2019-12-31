package leetcode;

import java.util.Arrays;

/**
 * @Classname MinPathSum
 * @Description TODO
 * @Date 2019/12/31 15:11
 * @Created by 14241
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid={
                {1,3,1},{1,5,1},{4,2,1}
        };
        System.out.println(minPathSum(grid));

    }
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m==0||n==0){
            return 0;
        }
        int[][] dp=new int[m][n];


        dp[0][0]=grid[0][0];

        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(dp[i-1][j]<dp[i][j-1]){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];

    }
}
