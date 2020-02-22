package leetcode;

/**
 * @Classname BestTimeToBuyAndSellStock
 * @Description TODO
 * @Date 2020/2/22 14:49
 * @Created by 14241
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(maxProfit<prices[j]-prices[i]){
                    maxProfit=prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }
}
