class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        
        for(int i=nums.length-2;i>=0;i--){
            int minMoves = Integer.MAX_VALUE;
            for(int j=1;j<=nums[i];j++){
                if(i+j<dp.length)
                    minMoves = Math.min(minMoves, dp[i+j]);
            }
            dp[i] = (minMoves == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minMoves + 1;
        }
        
        return dp[0];
    }
}