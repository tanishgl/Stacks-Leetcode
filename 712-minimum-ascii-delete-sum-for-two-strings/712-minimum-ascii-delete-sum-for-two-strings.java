class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = ch1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        // System.out.println(ascii(s1));
        // System.out.println(ascii(s2));
        // System.out.println(dp[0][0]);
        
        return ascii(s1) + ascii(s2) - 2 * dp[0][0];
    }
    
    public int ascii(String s){
        int ans = 0;
        for(int i=0;i<s.length();i++){
            ans += s.charAt(i);
        }
        
        return ans;
    }
}