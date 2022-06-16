class Solution {
    
    int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n+1][n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return helper(n, k, row, column, dp);
    }
    
    public double helper(int n, int k, int i, int j, double[][][] dp){
        if(k == 0) return 1.0;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        double prob = 0.0;
        for(int m=0;m<8;m++){
            int nr = i + moves[m][0];
            int nc = j + moves[m][1];
            
            if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                prob = prob + (1.0 / 8.0) * helper(n, k - 1, nr, nc, dp);
            }
        }
        
        return dp[i][j][k] = prob;
    }
}