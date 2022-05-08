class Solution {
    public static int[] press = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
    int mod = 1000000007;
    public int countTexts(String pressedKeys) {
        int[] dp = new int[pressedKeys.length()];
        dp[0] = 1;
        int freq = 1;
        
        for(int i=1;i<pressedKeys.length();i++){
            char ch = pressedKeys.charAt(i);
            if(i==0 || ch!=pressedKeys.charAt(i-1)){
                freq = 1;
            } else {
                freq++;
            }
            
            for(int j=1;j<=Math.min(freq, press[ch-'0']);j++){
                dp[i] += ( (i - j == -1) ? 1 : dp[i - j] );
                dp[i] %= mod;
            }
        }
        
        return dp[dp.length-1];
    }
}