class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int j=0;j<n;j++){
            dp[n-1][j] = matrix[n-1][j];
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int dl = (j-1 < 0) ? Integer.MAX_VALUE : dp[i+1][j-1];
                int dr = (j+1 < n) ? dp[i+1][j+1] : Integer.MAX_VALUE;
                int sd = dp[i+1][j];
                int ans = Math.min(sd, Math.min(dl, dr));
                dp[i][j] = (ans != Integer.MAX_VALUE) ? ans + matrix[i][j] : matrix[i][j];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans = Math.min(ans, dp[0][j]);
        }
        
        return ans;
    }
}