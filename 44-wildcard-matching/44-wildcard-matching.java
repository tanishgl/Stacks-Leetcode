class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return memo(0, 0, s, p, dp);
    }
    
    public boolean memo(int i, int j, String s, String p, Boolean[][] dp){
        if(i == s.length() && j == p.length()){
            return true;
        } else if (i == s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k) != '*')
                    return false;
            }
            return true;
        } else if (j == p.length()){
            return false;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        char ch1 = s.charAt(i);
        char ch2 = p.charAt(j);
        
        if(ch2 >= 'a' && ch2 <= 'z'){
            if(ch1 != ch2)
                return false;
            return dp[i][j] = memo(i+1, j+1, s, p, dp);
        } else if (ch2 == '?'){
            return dp[i][j] = memo(i+1, j+1, s, p, dp);
        } else if (ch2 == '*'){
            boolean no = memo(i, j+1, s, p, dp);
            boolean yes = memo(i+1, j, s, p, dp);
            return dp[i][j] = (no || yes);
        }
        
        return true;
    }
}