class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int need = (i-coins[j]>=0) ? dp[i-coins[j]] : Integer.MAX_VALUE;
                need = (need != Integer.MAX_VALUE) ? need + 1 : need;
                dp[i] = (dp[i] == 0) ? need : Math.min(dp[i], need);
            }
        }
        
        return ( dp[amount] != Integer.MAX_VALUE ) ? dp[amount] : -1;
    }
}