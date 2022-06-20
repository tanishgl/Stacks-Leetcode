class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(0, 0, s, p, dp) == 1;
    }
    
    public int helper(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() && j == s2.length())
            return 1;
        else if (i == s1.length()){
            for(int k=j;k<s2.length();k++){
                if(s2.charAt(k) != '*')
                    return 0;
            }
            return 1;
        }
        else if (j == s2.length())
            return 0;
        
        
        if(dp[i][j] != -1) return dp[i][j];
        
        char ch1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char ch2 = (j < s2.length()) ? s2.charAt(j) : 'B';
        
        if(ch2 == '?'){
            return dp[i][j] = helper(i + 1, j + 1, s1, s2, dp);
        } else if (ch2 == '*'){
            int mul = helper(i, j + 1, s1, s2, dp);
            int sin = helper(i + 1, j, s1, s2, dp);
            if(mul == 1 || sin == 1)
                return dp[i][j] = 1;
            else 
                return dp[i][j] = 0;
        } else {
            if(ch1 == ch2)
                return dp[i][j] = helper(i + 1, j + 1, s1, s2, dp);
            else 
                return dp[i][j] = 0;
        }
        
        
    }
}