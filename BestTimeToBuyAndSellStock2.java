package leetcode;

/**
 * @Classname BestTimeToBuyAndSellStock2
 * @Description TODO
 * @Date 2020/2/22 14:57
 * @Created by 14241
 * We have to determine the maximum profit
 * that can be obtained by making the transactions
 * (no limit on the number of transactions done).
 * For this we need to find out those sets of buying and
 * selling prices which together lead to the maximization of profit.
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }

        }
        return maxProfit;
    }
}
