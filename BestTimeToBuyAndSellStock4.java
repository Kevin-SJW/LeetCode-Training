package leetcode;

/**
 * @Classname BestTimeToBuyAndSellStock4
 * @Description TODO
 * @Date 2020/3/24 15:10
 * @Created by 14241
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 */
public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {

        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));

    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 0 || n == 0) {
            return 0;
        }
        // validate input 2 : if k is large enough,
        // the question will be the same as question II.
        if (k > n / 2) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][] localProfit = new int[n + 1][k];
        int[][] globalProfit = new int[n + 1][k];

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                localProfit[i][j] = Math.max(localProfit[i - 1][j] + prices[i] - prices[i - 1],
                        globalProfit[i - 1][j - 1] + Math.max(0, prices[i] - prices[i - 1]));
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i-1][j]);
            }
        }
        return globalProfit[n - 1][k];

    }
}
