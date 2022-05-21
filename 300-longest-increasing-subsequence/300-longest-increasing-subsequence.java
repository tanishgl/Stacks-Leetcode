class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}