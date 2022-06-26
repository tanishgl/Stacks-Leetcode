class Solution {
    int[] dp = new int[100001];
    
    public boolean winnerSquareGame(int n) {
        Arrays.fill(dp, -1);
        
        return helper(n, dp) == 1;
    }
    
    public int helper(int stones, int[] dp){
        if(stones <= 0)
            return 0;
        
        if(dp[stones] != -1) return dp[stones];
        
        for(int i=1;i*i<=stones;i++){
            if(helper(stones - (i*i), dp) == 0)
                return dp[stones] = 1;
        }
        
        return dp[stones] = 0;
    }
}