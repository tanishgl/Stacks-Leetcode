class Solution {
    public int findLengthOfLCIS(int[] nums) {
//         int[] dp = new int[nums.length];
        
//         for(int i=0;i<nums.length;i++){
//             dp[i] = 1;
//             if(i-1 >= 0 && nums[i] > nums[i-1]){
//                 dp[i] = dp[i-1] + 1;
//             }
//         }
        
//         int ans = 0;
//         for(int i=0;i<dp.length;i++){
//             ans = Math.max(dp[i], ans);
//         }
        
//         return ans;
        
        int currL = 1, maxL = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                currL += 1;
            } else {
                currL = 1;
            }
            maxL = Math.max(maxL, currL);
        }
        
        return maxL;
    }
}