class Solution {
    public int maxProfit(int[] prices) {
        //Rightmax.
        // int[] rm = new int[prices.length];
        // rm[prices.length-1] = prices[prices.length-1];
        // for(int i=prices.length-2;i>=0;i--){
        //     rm[i] = Math.max(prices[i], rm[i+1]);
        // }
        
        int sp = prices[prices.length-1], profit = Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--){
            sp = Math.max(sp, prices[i]);
            profit = Math.max(profit, sp - prices[i]);
        }
        // for(int i=0;i<rm.length;i++){
        //     max = Math.max(max, rm[i] - prices[i]);
        // }
        
        return profit;
    }
}