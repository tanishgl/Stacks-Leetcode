class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int hc = (j+1 >= m) ? Integer.MAX_VALUE : dp[i][j+1];
                int vc = (i+1 >= n) ? Integer.MAX_VALUE : dp[i+1][j];
                dp[i][j] = Math.min(hc,vc) + grid[i][j];
            }
        }
        
        return dp[0][0];
    }
}