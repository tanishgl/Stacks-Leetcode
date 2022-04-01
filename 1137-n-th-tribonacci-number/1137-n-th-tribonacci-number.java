class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            if(i==1 || i==2){
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        return dp[n];
    }
}