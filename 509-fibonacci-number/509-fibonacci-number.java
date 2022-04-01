class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;
        //Memoization
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        fibo(n,dp);
        return dp[n];
    }
    
    public int fibo(int n, int[] dp){
        if(n==0 || n==1) return n;
        
        if(dp[n]!=-1) return dp[n];
        
        dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n];
    }
}