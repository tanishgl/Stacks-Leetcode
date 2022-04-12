class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] a1 = new int[nums.length-1];
        int[] a2 = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)
            a1[i] = nums[i];
        for(int i=1;i<nums.length;i++)
            a2[i-1] = nums[i];
        return Math.max(tab(a1), tab(a2));
    }
    
    public int tab(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            int no = dp[i+1];
            int yes = (i+2 < n) ? dp[i+2] + nums[i] : nums[i];
            dp[i] = Math.max(no, yes);
        }
        
        return dp[0];
    }
}