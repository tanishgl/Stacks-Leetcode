class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0,0,word1,word2,dp);
    }
    
    public int helper(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() && j == s2.length())
            return 0;
        else if (j == s2.length())
            return s1.length() - i;
        else if (i == s1.length())
            return s2.length() - j;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        
        if(ch1 == ch2){
            return dp[i][j] = helper(i+1,j+1,s1,s2,dp);
        } else {
            int insert = helper(i,j+1,s1,s2,dp);
            int delete = helper(i+1,j,s1,s2,dp);
            int replace = helper(i+1,j+1,s1,s2,dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        
    }
}