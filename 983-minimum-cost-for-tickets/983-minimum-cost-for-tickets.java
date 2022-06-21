class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        
        for(int i=n-1;i>=0;i--){
            int day = days[i];
            
            int cost1 = Integer.MAX_VALUE;
            if(i == n-1)
                cost1 = costs[0];
            else 
                cost1 = costs[0] + dp[i+1];
            
            
            int cost7 = Integer.MAX_VALUE;
            if(i == n-1)
                cost7 = costs[1];
            else {
                int j = i + 1;
                while(j < n && days[j] < day + 7)
                    j++;
                cost7 = (j == n) ? costs[1] : dp[j] + costs[1];
            }
            
            
            int cost3 = Integer.MAX_VALUE;
            
            if(i == n-1)
                cost3 = costs[2];
            else {
                int j = i + 1;
                while(j < n && days[j] < day + 30)
                    j++;
                cost3 = (j == n) ? costs[2] : dp[j] + costs[2];
            }
            
            dp[i] = Math.min(cost1, Math.min(cost7, cost3));
        }
        
        return dp[0];
    }
}