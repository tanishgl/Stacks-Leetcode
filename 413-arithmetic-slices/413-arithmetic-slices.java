class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        
        int[] dp = new int[nums.length];
        int maxL = 0, currL = 0, count = 0;
        
        for(int i=2;i<nums.length;i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }
        
        int ans = 0;
        for(int i=2;i<nums.length;i++){
            ans += dp[i];
        }
        
        return ans;
    }
}