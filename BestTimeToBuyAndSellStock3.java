package leetcode;

/**
 * @Classname BestTimeToBuyAndSellStock3
 * @Description TODO
 * @Date 2020/2/22 15:06
 * @Created by 14241
 * You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again)
 * 第二种解法的核心是假设手上最开始只有0元钱，
 * 那么如果买入股票的价格为price，
 * 手上的钱需要减去这个price，
 * 如果卖出股票的价格为price，手上的钱需要加上这个price。
 */
public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int firstBuy=Integer.MIN_VALUE,firstSell=0;
        int secondBuy=Integer.MIN_VALUE,secondSell=0;
        for(int curPrice:prices){
            firstBuy=Math.max(firstBuy,-curPrice);
            firstSell=Math.max(firstSell,curPrice+firstBuy);
            secondBuy=Math.max(secondBuy,firstSell-curPrice);
            secondSell=Math.max(secondSell,curPrice+secondBuy);
        }
        return secondSell;
    }
}
