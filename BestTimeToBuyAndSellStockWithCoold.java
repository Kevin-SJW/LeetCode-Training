package leetcode;

/**
 * @Classname BestTimeToBuyAndSellStockWithCoold
 * @Description TODO
 * @Date 2020/4/24 16:28
 * @Created by 14241
 */
public class BestTimeToBuyAndSellStockWithCoold {
    public static void main(String[] args) {
        int[] prices={1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] buy = new int[prices.length]; // the profit after buy a price[i] or cooldown
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1] ,  sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}
