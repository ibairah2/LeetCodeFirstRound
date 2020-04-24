package com.ibairah.lc121;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */


/**
 * Created by ibairah on 4/22/20.
 */
public class main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] price = {7,1,5,3,6,4};
        sl.maxProfit(price);
        System.out.println(" sl.maxProfit(price); :"+ sl.maxProfit(price));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length == 0){
            return res;
        }
        else {
            int len_ = prices.length;

            int minprice = prices[0];

            int maxprofit = Integer.MIN_VALUE;

            for (int i = 0; i < len_; i++) {
                if (minprice > prices[i]) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }
}