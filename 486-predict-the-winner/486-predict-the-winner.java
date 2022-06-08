class Solution {
    public int helper(int left, int right, int[] arr, int[][] dp){
        if(left > right){
            return 0;
        }
        
        if(left == right)
            return arr[left];
        
        if(dp[left][right] != -1)
            return dp[left][right];
        
        int c1 = helper(left + 2, right, arr, dp);
        int c2 = helper(left + 1, right -1, arr, dp);
        int c3 = helper(left, right - 2, arr, dp);
        
        return dp[left][right] = Math.max(arr[left] + Math.min(c1, c2), arr[right] + Math.min(c2, c3));
    }
    
    public boolean PredictTheWinner(int[] nums) {    
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }
        
        int A = helper(0, nums.length-1, nums, dp);
        
        int total = 0;
        for(int val : nums){
            total += val;
        }
        
        int B = total - A;
        
        return A >= B;
    }
}