class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxL = 0;
        
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            if(dp[i] > maxL){
                maxL = dp[i];
            }
        }
        
        for(int i=0;i<dp.length;i++){
            for(int j=i;j>=0;j--){
                if(dp[i] == 1){
                    count[i] = 1;
                    break;
                }
                if(nums[j] < nums[i] && dp[j] == dp[i] - 1){
                    count[i] += count[j];
                }
            }
        }
        
        int ans = 0;
        for(int i=0;i<count.length;i++){
            if(dp[i] == maxL){
                ans += count[i];
            }
        }
        
        return ans;
    }
}