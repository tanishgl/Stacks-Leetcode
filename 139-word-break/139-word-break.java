class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String str : wordDict){
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=min;j<=max;j++){
                if(dp[i] == true)
                    break;
                if(i-j >= 0 && wordDict.contains(s.substring(i-j, i)) && dp[i-j]){
                    dp[i] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}