// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        long[][] dp = new long[2][n+1];
        
        long mod = 1000000007;
        dp[0][1] = 1;
        dp[1][1] = 1;
        for(int i=2;i<=n;i++){
            dp[0][i] = (dp[0][i-1] + dp[1][i-1]) % mod;
            dp[1][i] = dp[0][i-1] % mod;
        }
        
        // for(int i=0;i<=n;i++){
        //     System.out.println(dp[0][i] + " " + dp[1][i]);
        // }
        
        
        return (dp[0][n] + dp[1][n]) % mod;
    }
}