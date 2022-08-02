class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i=2;i<n;i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                dp[i] = dp[i-1] + 1;
        }
        
        int count = 0;
        for(int i=2;i<n;i++){
            count += dp[i];
        }
        
        return count;
    }
}