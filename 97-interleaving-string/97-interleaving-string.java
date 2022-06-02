class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() < s1.length() + s2.length())
            return false;
        int n = s1.length(), m = s2.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        
        return memo(0, 0, 0, s1, s2, s3, dp);
    }
    
    public boolean memo(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp){
        // Positive base case. Resultant is empty. All chars have been mapped.
        if(k == s3.length()){
            return true;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        char ch1 = (i == s1.length()) ? 'A' : s1.charAt(i);
        char ch2 = (j == s2.length()) ? 'B' : s2.charAt(j);
        char ch3 = s3.charAt(k);
        
        if(ch1 == ch3 && memo(i+1, j, k+1, s1, s2, s3, dp)){
            return dp[i][j] = true;
        }
        
        if(ch2 == ch3 && memo(i, j+1, k+1, s1, s2, s3, dp)){
            return dp[i][j] = true;
        }
        
        return dp[i][j] = false;
    }
}