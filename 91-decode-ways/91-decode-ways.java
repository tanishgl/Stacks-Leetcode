class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char ch = s.charAt(n-1);
        dp[n-1] = (ch-'0'>=1 && ch-'0'<=9) ? 1 : 0;
        
        for(int i=n-2;i>=0;i--){
            ch = s.charAt(i);
            dp[i] = (ch-'0'>=1 && ch-'0'<=9) ? dp[i+1] : 0;
            int x = Integer.parseInt(s.substring(i,i+2));
            dp[i] += (x>=10 && x<=26) ? ( (i + 2 < n) ? dp[i+2] : 1) : 0;
        }
        
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[0];
    }
}