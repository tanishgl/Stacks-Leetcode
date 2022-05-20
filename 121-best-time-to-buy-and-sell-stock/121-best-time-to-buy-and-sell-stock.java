class Solution {
    public int maxProfit(int[] prices) {
        int sell = prices[prices.length-1];
        int profit = 0;
        for(int i=prices.length-1;i>=0;i--){
            sell = Math.max(sell, prices[i]);
            profit = Math.max(profit, sell - prices[i]);
        }
        return profit;
    }
}