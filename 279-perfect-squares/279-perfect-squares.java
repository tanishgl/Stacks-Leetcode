class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = i;
        }
        
        for(int i=2;i*i<=n;i++){
            int num = i*i;
            for(int j=1;j<=n;j++){
                int coins = (j - num >=0) ? dp[j-num] : Integer.MAX_VALUE;
                if(coins != Integer.MAX_VALUE)
                    coins += 1;
                dp[j] = Math.min(dp[j] , coins);
            }
        }
        
        return dp[n];
    }
}