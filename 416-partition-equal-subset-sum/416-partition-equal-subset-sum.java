class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        if(sum % 2 != 0) return false;
        
        return solve(nums, sum / 2) == 1;
    }
    
    public int solve(int[] A, int B) {
        int[] prev = new int[B+1];
        prev[0] = 1;
        
        for(int i=1;i<=A.length;i++){
            int[] curr = new int[B+1];
            for(int j=0;j<=B;j++){
                int no = prev[j];
                int yes = (j - A[i-1] >= 0) ? prev[j - A[i-1]] : 0;
                curr[j] = (no == 1 || yes == 1) ? 1 : 0;
            }
            
            for(int j=0;j<=B;j++){
                prev[j] = curr[j];
            }
        }
        
        return prev[B];
    }
}