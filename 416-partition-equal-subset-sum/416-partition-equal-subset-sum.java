class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums)
            sum += val;
        if(sum % 2 != 0)
            return false;
        
        int target = sum / 2;
        
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        
        for(int i=1;i<=nums.length;i++){
            boolean[] curr = new boolean[target+1];
            for(int j=0;j<=target;j++){
                boolean no = prev[j];
                boolean yes = (j - nums[i-1] >= 0) ? prev[j - nums[i-1]] : false;
                curr[j] = no || yes;
            }
            
            for(int j=0;j<=target;j++)
                prev[j] = curr[j];
        }
        
        return prev[target];
    }
}