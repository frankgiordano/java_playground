package leetcode;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

*/
public class BestTimeBuySellStock {

    /**
     * Brute force solution Time O(n2)
     */
    public static int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];

            for (int j = i; j < prices.length; j++) {
                int sell = prices[j];
                int value = sell - buy;
                if (value > max)
                    max = value;
            }
        }

        return max;
    }

    /**
     * One Pass Time O(n)
     */
    public static int maxProfit2(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (final int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(BestTimeBuySellStock.maxProfit(prices));
        System.out.println(BestTimeBuySellStock.maxProfit2(prices));
    }

}
