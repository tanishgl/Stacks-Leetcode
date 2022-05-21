class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return lis(0,-1,nums,dp);
    }
    
    public int lis(int idx, int prev, int[] nums, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        
        int yes = (prev == -1 || nums[idx] > nums[prev]) ? lis(idx+1, idx, nums, dp) + 1 : 0;
        
        int no = lis(idx+1, prev, nums, dp);
        
        return dp[idx][prev+1] = Math.max(yes,no);
    }
}