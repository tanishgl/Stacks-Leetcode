class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return memo(text1, text2, 0, 0, dp);
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int n = text1.length(), m = text2.length();
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
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