class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(0, 0, s, t, dp);
    }
    
    public int recursion(int i, int j, String s, String t, int[][] dp){
        if(j == t.length()){
            return 1;
        }
        
        if(i == s.length()){
            return 0;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(j);
        
        int count = 0;
        
        if(ch1 == ch2){
            count = recursion(i+1, j+1, s, t, dp) + recursion(i+1, j, s, t, dp);
        } else {
            count = recursion(i+1, j, s, t, dp);
        }
        
        dp[i][j] = count;
        return count;
    }
}