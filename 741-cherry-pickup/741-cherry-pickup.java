class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        
        int max = helper(0,0,0,grid,dp);
        return (max < 0) ? 0 : max;
    }
    
    public int helper(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int c2 = r1 + c1 - r2;
        if(r1 >= grid.length || c1 >= grid.length || r2 >= grid.length || c2 >= grid.length || grid[r2][c2] == -1 || grid[r1][c1] == -1)
            return Integer.MIN_VALUE;
        
        if(r1 == grid.length-1 && c1 == grid.length-1)
            return grid[r1][c1];
        
        if(dp[r1][c1][r2] != 0) return dp[r1][c1][r2];
        
        int ans = grid[r1][c1] + grid[r2][c2];
        if(r1 == r2 && c1 == c2)
            ans -= grid[r1][c1];
        
        int ans1 = helper(r1 + 1, c1, r2 + 1, grid, dp);
        int ans2 = helper(r1, c1 + 1, r2, grid, dp);
        int ans3 = helper(r1 + 1, c1, r2, grid, dp);
        int ans4 = helper(r1, c1 + 1, r2 + 1, grid, dp);
        
        return dp[r1][c1][r2] = ans+Math.max(ans1,Math.max(ans2,(Math.max(ans3,ans4))));
    }
}