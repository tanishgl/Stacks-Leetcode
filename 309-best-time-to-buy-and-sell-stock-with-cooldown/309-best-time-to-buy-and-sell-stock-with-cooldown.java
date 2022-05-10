class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        
        int buy0 = prices[0] * -1;
        int sell0 = 0;
        int buy1 = Math.max(prices[1] * -1, buy0);
        int sell1 = Math.max(sell0, prices[1] + buy0);
        
        for(int i=2;i<prices.length;i++){
            //Either buy today.
            int newBuy = Math.max(buy1, sell0 - prices[i]);
            
            //Or Sell today.
            int newSell = Math.max(sell1, buy1 + prices[i]);
            
            buy0 = buy1;
            sell0 = sell1;
            buy1 = newBuy;
            sell1 = newSell;
        }
        
        return sell1;
    }
}