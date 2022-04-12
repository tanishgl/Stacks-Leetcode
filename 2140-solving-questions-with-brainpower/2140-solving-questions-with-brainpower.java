class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        int n = dp.length;
        dp[n-1] = questions[n-1][0];
        for(int i=n-2;i>=0;i--){
            long no = dp[i+1];
            long yes = (i + questions[i][1] + 1 < n) ? dp[i+questions[i][1]+1] + questions[i][0] : questions[i][0];
            dp[i] = Math.max(no, yes);
        }
        
        return dp[0];
    }
}