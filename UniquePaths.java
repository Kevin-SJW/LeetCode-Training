package leetcode;

/**
 * @Classname UniquePaths
 * @Description TODO
 * @Date 2019/12/28 15:55
 * @Created by 14241
 * 动态规划，当前值和左边格子与上边格子的状态有关；状态仅与当前行和上一行有关，
 * 并且由于是从上往下、从左往右遍历的，可以只使用一维数组存储。
 * 用一个ｍ*n的组数A保存结果。
 * 　　对于A数组中的元素有。
 * 　　1、当x=0或者y=0时有A[x][y] = 1；
 * 　　2、当x>=1而且y>=1时有A[\x][\y] = A[x-1][y]+A[\x][y-1]。
 * 　　3、所求的结点就是A[m-1][n-1]。
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m=3,n=2;
        System.out.println(uniquePaths(m,n));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        //第一行的解
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        //第一列的解
        for(int j=0;j<m;j++){
            dp[j][0]=1;
        }
        //其他位置的解
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //所求的解
        return dp[m-1][n-1];

    }
}
