class Solution {
    String SCS = "";
    public String shortestCommonSupersequence(String str1, String str2) {
        // LCS should come only once. Insert remaining characters to form SCS.
        // Length of SCS = |str1| + |str2| - |LCS(str1, str2)|
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        backtrack(0, 0, str1, str2, dp, SCS);
        return SCS;
    }
    
    public void backtrack(int i, int j, String s1, String s2, int[][] dp, String asf){
        if(i == s1.length() && j == s2.length()){
            SCS = asf;
            return;
        }
        
        char ch1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char ch2 = (j < s2.length()) ? s2.charAt(j) : 'B';
        
        if(ch1 == ch2){
            backtrack(i+1, j+1, s1, s2, dp, asf + ch1);
        } else if (i + 1 <= s1.length() && dp[i][j] == dp[i+1][j]){
            backtrack(i+1, j, s1, s2, dp, asf + ch1);
        } else {
            backtrack(i, j+1, s1, s2, dp, asf + ch2);
        }
    }
    
    
}