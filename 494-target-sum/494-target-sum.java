class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int val : nums)
            sum += val;
        
        if((sum - target) % 2 != 0 || target > sum) return 0;
        
        target = (sum - target) / 2;
        
        int[] prev = new int[target+1];
        prev[0] = 1;
        
        for(int i=1;i<=nums.length;i++){
            int[] curr = new int[target+1];
            for(int j=0;j<=target;j++){
                int no = prev[j];
                int yes = (j - nums[i-1] >= 0) ? prev[j - nums[i-1]] : 0;
                curr[j] = no + yes;
            }
            
            for(int j=0;j<=target;j++)
                prev[j] = curr[j];
        }
        
        return prev[target];
    }
}