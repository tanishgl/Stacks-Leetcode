class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return memo(text1, text2, 0, 0, dp);
    }
    
    public int memo(String s1, String s2, int i, int j, int[][] dp){
        if(i >= s1.length() || j >= s2.length())
            return 0;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans = 0;
        
        if(s1.charAt(i) == s2.charAt(j)){
            ans = memo(s1, s2, i+1, j+1, dp) + 1;
        } else {
            ans = Math.max(memo(s1, s2, i, j+1, dp) , memo(s1, s2, i+1, j, dp));
        }
        
        dp[i][j] = ans;
        return ans;
        
    }
}