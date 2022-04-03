class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0] == 1) return 0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = 1;
                    continue;
                }
                
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                
                dp[i][j] = (j+1 < m) ? dp[i][j+1] : 0;
                dp[i][j] += (i+1 < n) ? dp[i+1][j] : 0;
            }
        }
        
        return dp[0][0];
    }
}