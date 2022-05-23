class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        
        for(int i=n-1;i>=0;i--){
            int day = days[i];
            
            int cost1 = Integer.MAX_VALUE;
            int cost7 = Integer.MAX_VALUE;
            int cost30 = Integer.MAX_VALUE;
            
            // One - day pass.
            if(i==n-1){
                cost1 = costs[0];
            } else {
                cost1 = costs[0] + dp[i+1];
            }
            
            // Seven - day pass.
            if(i==n-1){
                cost7 = costs[1];
            } else {
                cost7 = costs[1];
                int invalidDay = day + 7;
                int j = i + 1;
                while(j < n && days[j] < invalidDay){
                    j++;
                }
                cost7 += (j == n) ? 0 : dp[j];
            }
            
            // Thirty - day pass.
            if(i==n-1){
                cost30 = costs[2];
            } else {
                cost30 = costs[2];
                int invalidDay = day + 30;
                int j = i + 1;
                while(j < n && days[j] < invalidDay)
                    j++;
                cost30 += (j == n) ? 0 : dp[j];
            }
            
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        
        return dp[0];
        
    }
}