class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k==0) return 0;
        
        int[] prev = new int[prices.length];
        
        for(int i=1;i<=k;i++){
            int[] curr = new int[prices.length];
            for(int j=1;j<prices.length;j++){
                for(int l=j-1;l>=0;l--){
                    curr[j] = Math.max(curr[j], (prices[j]-prices[l]) + prev[l]);
                }
                curr[j] = Math.max(curr[j-1], curr[j]);
            }
            
            for(int j=0;j<prices.length;j++){
                prev[j] = curr[j];
            }
        }
        
        return prev[prices.length-1];
    }
}