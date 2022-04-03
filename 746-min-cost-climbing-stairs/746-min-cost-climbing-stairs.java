class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        int[] dp = new int[top+1];
        dp[top] = 0;
        
        for(int i=top-1;i>=0;i--){
            dp[i] = dp[i+1];
            if(i+2 < dp.length)
                dp[i] = Math.min(dp[i], dp[i+2]);
            dp[i] += cost[i];
        }
        
        return Math.min(dp[0], dp[1]);
        
    }
}