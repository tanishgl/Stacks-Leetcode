class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        int scoreA = game(0, n - 1, nums, dp);
        
        int total = 0;
        for(int score : nums)
            total += score;
        
        int scoreB = total - scoreA;
        
        return scoreA >= scoreB;
    }
    
    public int game(int l, int r, int[] nums, int[][] dp){
        if(l > r)
            return 0;
        
        if(l == r)
            return nums[l];
        
        if(dp[l][r] != -1) return dp[l][r];
        
        return dp[l][r] = Math.max(nums[l] + Math.min(game(l+2, r, nums, dp), game(l+1, r-1, nums, dp)), nums[r] + Math.min(game(l+1, r-1, nums, dp), game(l, r-2, nums, dp)));
    }
}