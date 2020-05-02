package leetcode;

/**
 * @Classname CoinChange
 * @Description TODO
 * @Date 2020/5/2 16:12
 * @Created by 14241
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up
 * that amount. If that amount of money cannot be made up by
 * any combination of the coins, return -1.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }

    public static int coinChange(int[] coins, int amount) {
        //dp[i]：金额为i时所需的最少硬币数     i范围:0~amount
        int[] dp = new int[amount + 1];
        //金额0显然需要0个硬币
        dp[0] = 0;
        //初始化数组，初始认定所有金额都无法拼凑出
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        //递推---两层循环
        //外循环：所有金额
        for (int i = 1; i <= amount; i++) {
            //内循环：所有硬币面值
            for (int j = 0; j < coins.length; j++) {
                //循环条件
                //金额i比硬币面值大 &&  i比硬币面值多出的部分能被拼凑出
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    //金额i不能被直接拼凑出  || 拼凑i的最少硬币数比dp[i-coin[j]]+1大
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
