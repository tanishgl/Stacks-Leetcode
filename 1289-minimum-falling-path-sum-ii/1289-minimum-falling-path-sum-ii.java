class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[n-1][i] = grid[n-1][i];
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int left = findMin(dp[i+1], 0, j-1);
                int right = findMin(dp[i+1], j+1, n-1);
                int ans = Math.min(left, right);
                dp[i][j] = (ans == Integer.MAX_VALUE) ? grid[i][j] : grid[i][j] + ans;
            }
        }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
            ans = Math.min(ans, dp[0][j]);
        
        return ans;
    }
    
    public int findMin(int[] arr, int i, int j){
        int ans = Integer.MAX_VALUE;
        if(i<0 || j>=arr.length) return ans;
        for(int a=i;a<=j;a++){
            ans = Math.min(ans, arr[a]);
        }
        return ans;
    }
}