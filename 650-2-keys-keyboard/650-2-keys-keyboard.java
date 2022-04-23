class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        int[][] dp = new int[2 * n + 1][2 * n + 1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return 1 + mem(dp, 1, 1, n);
    }
    
    public int mem(int[][] dp, int screen, int buffer, int n){
        if(screen == n){
            return 0;
        }
        
        if(screen > n) 
            return Integer.MAX_VALUE;
        
        if(dp[screen][buffer]!=-1) return dp[screen][buffer];
        
        int copyPaste = mem(dp, 2 * screen, screen, n);
        if(copyPaste != Integer.MAX_VALUE)
            copyPaste += 2;
        int paste = mem(dp, screen + buffer, buffer, n);
        if(paste != Integer.MAX_VALUE)
            paste++;
        
        dp[screen][buffer] = Math.min(copyPaste, paste);
        return dp[screen][buffer];
    }
}