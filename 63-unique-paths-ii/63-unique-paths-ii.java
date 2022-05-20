class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1] == 1) return 0;
        if(grid[0][0] == 1) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(grid[i][j] == 1){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                
                if(i==n-1 && j==m-1){
                    dp[i][j] = 1;
                    continue;
                }
                
                int hor = (j + 1 < m) ? dp[i][j+1] : 0;
                int ver = (i + 1 < n) ? dp[i+1][j] : 0;
                
                if(hor != Integer.MAX_VALUE && ver != Integer.MAX_VALUE){
                    dp[i][j] = hor + ver;
                } else if (hor != Integer.MAX_VALUE){
                    dp[i][j] = hor;
                } else if (ver != Integer.MAX_VALUE){
                    dp[i][j] = ver;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[0][0];
    }
}