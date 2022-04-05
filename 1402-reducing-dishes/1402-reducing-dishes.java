class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], -1);
        return rec(satisfaction, 1, 0, dp);
    }
    
    public int rec(int[] arr, int n, int idx, int[][] dp){
        if(idx==arr.length){
            return 0;
        }
        
        if(dp[idx][n] != -1) return dp[idx][n];
        
        int yes = rec(arr, n+1, idx + 1, dp) + arr[idx]*n;
        
        int no = rec(arr, n, idx + 1, dp);
        
        int ans = Math.max(yes, no);
        dp[idx][n] = ans;
        return ans;
        
    }
}