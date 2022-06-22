class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int val : nums)
            sum += val;
        if(sum % k != 0) return false;
        
        int target = sum / k;
        boolean[] vis = new boolean[nums.length];
        return helper(nums, 0, k, 0, target, vis);
    }
    
    public boolean helper(int[] nums, int idx, int k, int sum, int target, boolean[] vis){
        // System.out.println(idx + " " + k + " " + sum);
        if(k == 0) return true;
        if(sum == target) return helper(nums, 0, k - 1, 0, target, vis);
        
        for(int i=idx;i<nums.length;i++){
            if(!vis[i] && sum + nums[i] <= target){
                vis[i] = true;
                boolean ans = helper(nums, i + 1, k, sum + nums[i], target, vis);
                if(ans) return true;
                vis[i] = false;
            }
        }
        
        return false;
    }
}