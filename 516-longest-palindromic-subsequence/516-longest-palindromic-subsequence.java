class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String p = sb.reverse().toString();
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char ch = s.charAt(i);
                char ch2 = p.charAt(j);
                if(ch == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }
    
}