class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        return n + m - 2 * dp[0][0];
    }
}