// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.dyckPaths(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long dyckPaths(int N) {
        // code here
        if(N == 0 || N == 1) return 1l;
        
        long[] dp = new long[N+1];
        dp[0] = 1l;
        dp[1] = 1l;
        
        for(int i=2;i<=N;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        
        return dp[N];
    }
};