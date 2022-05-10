class Solution {
    public int maxProfit(int[] prices) {
        int buying = prices[0];
        int[] ans = new int[prices.length];
        
        int profit = 0;
        
        for(int i=0;i<prices.length;i++){
            buying = Math.min(buying, prices[i]);
            profit = Math.max(profit, prices[i] - buying);
            ans[i] = profit;
        }
        
        int selling = prices[prices.length-1];
        profit = 0;
        for(int i=prices.length-1;i>=0;i--){
            selling = Math.max(selling, prices[i]);
            profit = Math.max(profit, selling - prices[i]);
            ans[i] += profit;
        }
        
        int fans = 0;
        for(int i=0;i<prices.length;i++){
            fans = Math.max(fans, ans[i]);
        }
        
        return fans;
    }
}