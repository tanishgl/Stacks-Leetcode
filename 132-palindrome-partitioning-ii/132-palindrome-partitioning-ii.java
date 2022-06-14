class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        
        return helper(s, 0, dp);
    }
    
    public boolean isPallindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    public int helper(String s, int i, int[] dp){
        if(i == s.length()){
            return 0;
        }
        
        if(isPallindrome(s.substring(i))) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int cuts = Integer.MAX_VALUE;
        
        for(int k=i;k<s.length();k++){
            String left = s.substring(i, k+1);
            if(isPallindrome(left)){
                cuts = Math.min(cuts, helper(s, k+1, dp) + 1);
            }
        }
        
        return dp[i] = cuts;
    }
}